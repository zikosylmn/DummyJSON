package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyJSON.DummyJsonAddProductsAPI;
import starter.dummyJSON.DummyJsonResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class AddProductsStepDef {

    @Steps
    DummyJsonAddProductsAPI dummyJsonAddProductsAPI;
    @Given("Post add product with valid json {string}")
    public void postAddProductWithValidJson(String json)
    {
        File jsonAddProducts =new File(Constants.REQ_BODY+json);
        dummyJsonAddProductsAPI.postAddProducts(jsonAddProducts);
    }

    @When("Send request post add products")
    public void sendRequestPostAddProducts()
    {
        SerenityRest.when().post(DummyJsonAddProductsAPI.POST_ADD_PRODUCTS);
    }

    @Then("Status code add products should be {int}")
    public void statusCodeAddProductsShouldBe(int statusCode)
    {
        SerenityRest.then()
                .statusCode(statusCode);
    }
    @And("Response body add products id={int}")
    public void responseBodyAddProductsId(int id)
    {
    SerenityRest.and()
        .body(DummyJsonResponses.ID, equalTo(id));
    }

    @And("Validate add product json schema {string}")
    public void validateAddProductJsonSchema(String json)
    {
        File jsonAddProducts =new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonAddProducts));
    }


    @Given("Post add product with invalid json {string}")
    public void postAddProductWithInvalidJson(String json)
    {
        File jsonAddProducts =new File(Constants.REQ_BODY+json);
        dummyJsonAddProductsAPI.postAddProducts(jsonAddProducts);
    }

    @And("Response body add products message {string}")
    public void responseBodyAddProductsMessage(String message)
    {
        SerenityRest.and()
                .body(DummyJsonResponses.MESSAGE, equalTo(message));
    }
}
