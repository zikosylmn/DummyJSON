package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import jnr.constants.Constant;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyJSON.DummyJsonLoginAPI;
import starter.dummyJSON.DummyJsonResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepDef {

    @Steps
    DummyJsonLoginAPI dummyJsonLoginAPI;
    @Given("Login user with entired data {string}")
    public void loginUserWithEntiredData(String json) {
        File jsonLoginUser = new File(Constants.REQ_BODY+json);
        dummyJsonLoginAPI.loginUser(jsonLoginUser);
    }

    @When("Send request login user")
    public void sendRequestLoginUser() {
        SerenityRest.when().post(DummyJsonLoginAPI.LOGIN_USER);
    }

    @Then("Status code login user should be {int}")
    public void statusCodeLoginUserShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body login user as id {int} as firstName {string} as lastName {string}")
    public void responseBodyLoginUserAsIdAsFirstNameAsLastName(int id, String firstName, String lastName) {
        SerenityRest.and()
                .body(DummyJsonResponses.ID, equalTo(id))
                .body(DummyJsonResponses.FIRST_NAME, equalTo(firstName))
                .body(DummyJsonResponses.LAST_NAME, equalTo(lastName));
    }

    @And("Validate login user json schema {string}")
    public void validateLoginUserJsonSchema(String json) {
        File jsonLoginUserSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonLoginUserSchema));
    }

    @Given("Login user with invalid data {string}")
    public void loginUserWithInvalidData(String json) {
        File jsonLoginUserSchema = new File(Constants.REQ_BODY+json);
        dummyJsonLoginAPI.loginUser(jsonLoginUserSchema);
    }

    @When("Send request login user invalid")
    public void sendRequestLoginUserInvalid() {
        SerenityRest.when().post(DummyJsonLoginAPI.LOGIN_USER);
    }

    @And("Response body login user invalid {string}")
    public void responseBodyLoginUserInvalid(String message) {
        SerenityRest.and()
                .body(DummyJsonResponses.MESSAGE, equalTo(message));
    }
}
