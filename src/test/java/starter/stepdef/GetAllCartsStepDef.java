package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyJSON.DummyJsonGetAllCartsAPI;
import starter.dummyJSON.DummyJsonResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetAllCartsStepDef {

    @Steps
    DummyJsonGetAllCartsAPI dummyJsonGetAllCartsAPI;

    @Given("Get all carts with valid path")
    public void getAllCartsWithValidPath() {
    dummyJsonGetAllCartsAPI.getAllCarts();
    }

    @When("Send request get all carts")
    public void sendRequestGetAllCarts() {
        SerenityRest.when().get(DummyJsonGetAllCartsAPI.GET_ALL_CARTS);
    }

    @Then("Status code get all carts should be {int}")
    public void statusCodeGetAllCartsShouldBe(int statusCode) {
    SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body should be total {int}")
    public void responseBodyShouldBe(int total) {
    SerenityRest.and()
            .body(DummyJsonResponses.TOTAL, equalTo(total));
    }
    @And("Validate get all carts json schema {string}")
    public void validateGetAllCartsJsonSchema(String json) {
        File jsonSchemaGetAllCarts = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                    .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaGetAllCarts));
    }

    @Given("Get all carts with invalid path")
    public void getAllCartsWithInvalidPath() {
        dummyJsonGetAllCartsAPI.getAllCarts();
    }

    @When("Send request get all carts invalid path")
    public void sendRequestGetAllCartsInvalidPath() {
        SerenityRest.when().get(DummyJsonGetAllCartsAPI.INVALID_GET_ALL_CARTS);
    }
}
