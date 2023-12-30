package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyJSON.DummyJsonDeleteProductsAPI;
import starter.dummyJSON.DummyJsonResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteProductsStepDef {
    @Steps
    DummyJsonDeleteProductsAPI dummyJsonDeleteProductsAPI;
    @Given("Delete products with valid id {int}")
    public void deleteProductsWithValidIdId(int id)
    {
        dummyJsonDeleteProductsAPI.deleteProducts(id);
    }

    @When("Send request delete products")
    public void sendRequestDeleteProducts()
    {
        SerenityRest.when().delete(DummyJsonDeleteProductsAPI.DELETE_PRODUCTS);
    }

    @Given("Delete user with invalid id {int}")
    public void deleteUserWithInvalidId(int id)
    {
        dummyJsonDeleteProductsAPI.deleteProducts(id);
    }


    @And("Body response delete products {int}")
    public void bodyResponseDeleteProductsId(int id)
    {
        SerenityRest.and().body(DummyJsonResponses.ID, equalTo(id));
    }

    @And("Validate delete products json schema {string}")
    public void validateDeleteACartJsonSchema(String json)
    {
        File jsonDeleteCartSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonDeleteCartSchema));
    }

    @And("Body Response delete products invalid {string}")
    public void bodyResponseDeleteProductsInvalid(String message)
    {
        SerenityRest.and()
                .body(DummyJsonResponses.MESSAGE, equalTo(message));
    }
}
