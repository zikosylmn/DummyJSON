package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyJSON.DummyJsonLimitSkipCartsAPI;
import starter.dummyJSON.DummyJsonResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class LimitSkipCartsStepDef {

    @Steps
    DummyJsonLimitSkipCartsAPI dummyJsonLimitSkipCartsAPI;
    @Given("Limit & skip carts with valid parameter limit as {int} & skip as {int}")
    public void limitSkipCartsWithValidParameterLimitAsSkipAs(int limit, int skip) {
        dummyJsonLimitSkipCartsAPI.limitSkipCarts(limit, skip);
    }

    @When("Send request limit & skip carts")
    public void sendRequestLimitSkipCarts() {
        SerenityRest.when().get(DummyJsonLimitSkipCartsAPI.LIMIT_SKIP_CARTS);
    }

    @Then("Status code limit & skip should be {int}")
    public void statusCodeLimitSkipShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Body response limit & skip carts total as {int} & limit as {int} & skip as {int}")
    public void bodyResponseLimitSkipCartsTotalAsLimitAsSkipAs(int total, int limit, int skip) {
        SerenityRest.and()
                .body(DummyJsonResponses.TOTAL, equalTo(total))
                .body(DummyJsonResponses.LIMIT, equalTo(limit))
                .body(DummyJsonResponses.SKIP, equalTo(skip));
    }

    @And("Validate limit & skip carts json schema {string}")
    public void validateLimitSkipCartsJsonSchema(String json) {
        File jsonLimitSkipCartsSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonLimitSkipCartsSchema));
    }


    @Given("Limit & skip carts with invalid parameter limit as {string} & skip as {int}")
    public void limitSkipCartsWithInvalidParameterLimitAsSkipAs(String chara, int skip) {
        dummyJsonLimitSkipCartsAPI.limitSkipCartsInvalid(chara, skip);
    }
    @When("Send request limit & skip carts invalid")
    public void sendRequestLimitSkipCartsInvalid() {
        SerenityRest.when().get(DummyJsonLimitSkipCartsAPI.INVALID_LIMIT_SKIP_CARTS);
    }

    @And("Body response limit & skip carts get {string}")
    public void bodyResponseLimitSkipCartsGet(String message) {
        SerenityRest.and()
                .body(DummyJsonResponses.MESSAGE, equalTo(message));
    }

}
