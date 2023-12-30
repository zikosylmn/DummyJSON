package starter.stepdef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.dummyJSON.DummyJsonGetSearchProductsAPI;

public class GetSearchProductsStepDef {
    @Steps
    DummyJsonGetSearchProductsAPI dummyJsonGetSearchProductsAPI;
    @Given("Search products users with query {string}")
    public void searchProductsUsersWithQuery(String query) {
        dummyJsonGetSearchProductsAPI.searchProducts(query);
    }

}
