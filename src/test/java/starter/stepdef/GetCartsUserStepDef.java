package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyJSON.DummyJsonCartsUserAPI;
import starter.dummyJSON.DummyJsonResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetCartsUserStepDef {

    @Steps
    DummyJsonCartsUserAPI dummyJsonCartsUserAPI;

    @Given("Get carts of a user with valid path {int}")
    public void getCartsOfAUserWithValidPath(int id) {
        dummyJsonCartsUserAPI.getCartsUser(id);
    }

    @When("Send request get carts of a user")
    public void sendRequestGetCartsOfAUser() {
        SerenityRest.when().get(DummyJsonCartsUserAPI.GET_CARTS_USER);
    }

    @Then("Status code get carts of a user should be {int}")
    public void statusCodeGetCartsOfAUserShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Body response get carts of a user should be {int}")
    public void bodyResponseGetCartsOfAUserShouldBe(int id) {
    SerenityRest.and().body(DummyJsonResponses.CARTS_ID, equalTo(id));
    }

    @And("Validate get carts of a user json schema {string}")
    public void validateGetCartsOfAUserJsonSchema(String json) {
        File jsonCartsUser = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonCartsUser));
    }

    @Given("Get carts of user with invalid path {string}")
    public void getCartsOfUserWithInvalidPath(String chara) {
        dummyJsonCartsUserAPI.getCartsUserInvalid(chara);
    }
    @When("Send request get carts of a user invalid")
    public void sendRequestGetCartsOfAUserInvalid() {
        SerenityRest.when().get(DummyJsonCartsUserAPI.INVALID_GET_CARTS_USER);
    }
    @And("Response body get carts of a user should be {string}")
    public void responseBodyGetCartsOfAUserShouldBe(String message) {
        SerenityRest.and().body(DummyJsonResponses.MESSAGE, equalTo(message));
    }
}
