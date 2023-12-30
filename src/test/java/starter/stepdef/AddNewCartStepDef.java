package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyJSON.DummyJsonAddCartAPI;
import starter.dummyJSON.DummyJsonResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class AddNewCartStepDef {

    @Steps
    DummyJsonAddCartAPI dummyJsonAddCartAPI;
    @Given("Add a new cart with valid data json {string}")
    public void addANewCartWithValidDataJson(String json) {
        File jsonAddNewCart = new File(Constants.REQ_BODY+json);
        dummyJsonAddCartAPI.addNewCart(jsonAddNewCart);
    }

    @When("Send request add a new cart")
    public void sendRequestAddANewCart() {
        SerenityRest.when().post(DummyJsonAddCartAPI.ADD_NEW_CART);
    }

    @Then("Status code add a new cart should be {int}")
    public void statusCodeAddANewCartShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body add a new cart id={int}")
    public void responseBodyAddANewCart(int id) {
        SerenityRest.and().body(DummyJsonResponses.ID, equalTo(id));
    }

    @And("Validate add a new cart json schema {string}")
    public void validateAddANewCartJsonSchema(String json) {
        File jsonAddNewCartSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonAddNewCartSchema));
    }

    // INVALID

    @Given("Add a new cart with invalid data id json {string}")
    public void addANewCartWithInvalidDataIdJson(String json) {
        File jsonAddCartInvalid = new File(Constants.REQ_BODY+json);
        dummyJsonAddCartAPI.addNewCart(jsonAddCartInvalid);
    }

    @When("Send request add a new cart invalid")
    public void sendRequestAddANewCartInvalid() {
        SerenityRest.when().post(DummyJsonAddCartAPI.ADD_NEW_CART);
    }

    @And("Body Response add a new cart invalid {string}")
    public void bodyResponseAddANewCartInvalid(String message) {
        SerenityRest.and()
                .body(DummyJsonResponses.MESSAGE, equalTo(message));
    }
    @And("Validate add a new cart invalid json schema {string}")
    public void validateAddANewCartInvalidJsonSchema(String json) {
        File jsonAddCartInvalidSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonAddCartInvalidSchema));
    }

}
