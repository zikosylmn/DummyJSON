package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyJSON.DummyJsonDeleteCartAPI;
import starter.dummyJSON.DummyJsonResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteCartStepDef {

    @Steps
    DummyJsonDeleteCartAPI dummyJsonDeleteCartAPI;
    @Given("Delete a cart with valid path {int}")
    public void deleteACartWithValidPath(int id) {
        dummyJsonDeleteCartAPI.deleteCart(id);
    }

    @When("Send request delete a cart")
    public void sendRequestDeleteACart() {
        SerenityRest.when().delete(DummyJsonDeleteCartAPI.DELETE_CARTS);
    }

    @Then("Status code delete a cart should be {int}")
    public void statusCodeDeleteACartShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Body response delete a cart {int}")
    public void bodyResponseDeleteACart(int id) {
        SerenityRest.and().body(DummyJsonResponses.ID, equalTo(id));
    }

    @And("Validate delete a cart json schema {string}")
    public void validateDeleteACartJsonSchema(String json) {
        File jsonDeleteCartSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonDeleteCartSchema));
    }

    @Given("Delete a cart with invalid path {string}")
    public void deleteACartWithInvalidPath(String chara) {
        dummyJsonDeleteCartAPI.deleteCartInvalid(chara);
    }

    @When("Send request delete a cart invalid")
    public void sendRequestDeleteACartInvalid() {
        SerenityRest.when().delete(DummyJsonDeleteCartAPI.INVALID_DELETE_CARTS);
    }
    @And("Body Response delete a cart invalid {string}")
    public void bodyResponseDeleteACartInvalid(String message) {
        SerenityRest.and()
                .body(DummyJsonResponses.MESSAGE, equalTo(message));
    }
}
