package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyJSON.DummyJsonGetSingleProductsAPI;
import starter.dummyJSON.DummyJsonResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleProductsStepDef {
    @Steps
    DummyJsonGetSingleProductsAPI dummyJsonGetSingleProductsAPI;
    @Given("Get single products with valid {int}")
    public void getSingleUserWithValid(int id) {
        dummyJsonGetSingleProductsAPI.getSingleProducts(id);
    }
    @When("Send request get single products")
    public void sendRequestGetSingleProducts()
    {
        SerenityRest.when()
                .get(DummyJsonGetSingleProductsAPI.GET_SINGLE_PRODUCT);
    }

    @And("Response body single products id should be {int}")
    public void responseBodySingleProductsIdShouldBeId(int id)
    {
        SerenityRest.and()
                .body(DummyJsonResponses.ID,equalTo(id));
    }

    @And("Validate get single products json schema {string}")
    public void validateGetSingleProductsJsonSchema(String json)
    {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get single products with invalid id {int}")
    public void getSingleProductsWithCharacterAlphanumericId(int id)
    {
        dummyJsonGetSingleProductsAPI.getSingleProducts(id);
    }

    @When("Send request get single products with invalid path")
    public void sendRequestGetSingleProductsWithInvalidPath()
    {
        SerenityRest.when()
                .get(DummyJsonGetSingleProductsAPI.GET_SINGLE_PRODUCT_INVALID);
    }
}
