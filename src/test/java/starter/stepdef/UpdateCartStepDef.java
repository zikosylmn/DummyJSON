package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyJSON.DummyJsonResponses;
import starter.dummyJSON.DummyJsonUpdateCartAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateCartStepDef {

    @Steps
    DummyJsonUpdateCartAPI dummyJsonUpdateCartAPI;
    @Given("Update a cart with valid data json {string}")
    public void updateACartWithValidDataJson(String json) {
        File jsonUpdateCart = new File(Constants.REQ_BODY+json);
        dummyJsonUpdateCartAPI.updateCart(jsonUpdateCart);
    }

    @When("Send request update a cart")
    public void sendRequestUpdateACart() {
        SerenityRest.when().put(DummyJsonUpdateCartAPI.UPDATE_CART);
    }

    @Then("Status code update a cart should be {int}")
    public void statusCodeUpdateACartShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Body response update a cart id={int}")
    public void bodyResponseUpdateACartId(int id) {
        SerenityRest.and().body(DummyJsonResponses.ID, equalTo(id));
    }

    @And("Validate update a cart json schema {string}")
    public void validateUpdateACartJsonSchema(String json) {
        File jsonUpdateCartSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonUpdateCartSchema));
    }

    @Given("Update a cart with invalid data json {string}")
    public void updateACartWithInvalidDataJson(String json) {
        File jsonUpdateCartInvalid = new File(Constants.REQ_BODY+json);
        dummyJsonUpdateCartAPI.updateCart(jsonUpdateCartInvalid);
    }

    @When("Send request update a cart invalid")
    public void sendRequestUpdateACartInvalid() {
        SerenityRest.when().put(DummyJsonUpdateCartAPI.UPDATE_CART);
    }
}
