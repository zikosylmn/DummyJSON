package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyJSON.DummyJsonLimitSkipCartsAPI;
import starter.dummyJSON.DummyJsonLimitSkipProductsAPI;
import starter.dummyJSON.DummyJsonResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class LimitSkipProductsStepDef {
    @Steps
    DummyJsonLimitSkipProductsAPI dummyJsonLimitSkipProductsAPI;
//    @Given("products limskip with valid parameter limit as {int} & skip as {int}")
//    public void ProductsLimskipWithValidParameterLimitAsSkipAs(int limit, int skip) {
//        dummyJsonLimitSkipProductsAPI.limitSkipProducts(limit, skip);
//    }
//
//    @When("Send request products limskip")
//    public void sendRequestProductsLimskip() {
//        SerenityRest.when().get(DummyJsonLimitSkipProductsAPI.LIMIT_SKIP_PRODUCTS);
//    }

    @Then("Status codes limit_skip should be {int}")
    public void statusCodeLimit_SkipShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

//    @And("Body response limit_skip products total as {int} & limit as {int} & skip as {int}")
//    public void bodyResponseLimit_SkipProductsTotalAsLimitAsSkipAs(int total, int limit, int skip) {
//        SerenityRest.and()
//                .body(DummyJsonResponses.TOTAL, equalTo(total))
//                .body(DummyJsonResponses.LIMIT, equalTo(limit))
//                .body(DummyJsonResponses.SKIP, equalTo(skip));
//    }

    @And("Validates limit_skip products json schema {string}")
    public void validateLimit_SkipProductsJsonSchema(String json) {
        File jsonLimitSkipProductsSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonLimitSkipProductsSchema));
    }

//////////////////////////////////////////////
    @Given("Limit_skip products with invalid parameter limit as {string} & skip as {int}")
    public void limit_SkipProductsWithInvalidParameterLimitAsSkipAs(String chara, int skip) {
        dummyJsonLimitSkipProductsAPI.limitSkipProductsInvalid(chara, skip);
    }
    @When("Send request limit_skip products invalid")
    public void sendRequestLimit_SkipProductsInvalid() {
        SerenityRest.when().get(DummyJsonLimitSkipProductsAPI.INVALID_LIMIT_SKIP_PRODUCTS);
    }

    @And("Body response limit_skip products get {string}")
    public void bodyResponseLimit_SkipProductsGet(String message) {
        SerenityRest.and()
                .body(DummyJsonResponses.MESSAGE, equalTo(message));
    }
}
