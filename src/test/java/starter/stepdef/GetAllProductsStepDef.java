package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyJSON.DummyJsonGetAllProductsAPI;
import starter.dummyJSON.DummyJsonResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetAllProductsStepDef {
    @Steps
    DummyJsonGetAllProductsAPI dummyJsonGetAllProductsAPI;
    @When("Send request get all products")
    public void sendRequestGetAllProducts()
    {
        SerenityRest.when().get(DummyJsonGetAllProductsAPI.GET_ALL_PRODUCT);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode)
    {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body total should be {int}")
    public void responseBodyTotalShouldBe(int total)
    {
        SerenityRest.and().body(DummyJsonResponses.TOTAL,equalTo(total));
    }

    @And("Validate get all product json schema {string}")
    public void validateGetAllProductJsonSchema(String json)
    {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @When("Send request get all products with invalid path")
    public void sendRequestGetAllProductsWithInvalidPath()
    {
        SerenityRest.when().get(DummyJsonGetAllProductsAPI.GET_ALL_PRODUCT_INVALID);
    }
}
