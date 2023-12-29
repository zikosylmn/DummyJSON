package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.dummyJSON.DummyJsonGetSingleCartsAPI;
import starter.dummyJSON.DummyJsonResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetSingleCartsStepDef {

    @Steps
    DummyJsonGetSingleCartsAPI dummyJsonGetSingleCartsAPI;
    @Given("Get a single carts with valid {int}")
    public void getASingleCartsWithValid(int id) {
        dummyJsonGetSingleCartsAPI.getSingleCarts(id);
    }

    @When("Send request get a single carts")
    public void sendRequestGetASingleCarts() {
        SerenityRest.when().get(DummyJsonGetSingleCartsAPI.GET_SINGLE_CARTS);
    }
    @Then("Status code get a single carts should be {int}")
    public void statusCodeGetASingleCartsShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body should be {int}")
    public void responseBodyShouldBe(int id) {
    SerenityRest.and()
            .body(DummyJsonResponses.ID, equalTo(id));
    }

    @And("Validate get a single carts json schema {string}")
    public void validateGetASingleCartsJsonSchema(String json) {
        File jsonGetSingleCarts = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonGetSingleCarts));
    }

    @Given("Get a single carts with invalid path {string}")
    public void getASingleCartsWithInvalidPath(String chara) {
        dummyJsonGetSingleCartsAPI.getSingleCartsInvalid(chara);
    }

    @When("Send request get a single carts invalid")
    public void sendRequestGetASingleCartsInvalid() {
        SerenityRest.when().get(DummyJsonGetSingleCartsAPI.INVALID_GET_SINGLE_CARTS);
    }
}
