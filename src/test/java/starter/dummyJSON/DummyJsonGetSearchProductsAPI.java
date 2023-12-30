package starter.dummyJSON;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DummyJsonGetSearchProductsAPI {
    public static final String SEARCH_PRODUCT_VALID = "https://dummyjson.com/products/search?q={query}";

    @Step("Search products")
    public void searchProducts(String query) {
        SerenityRest.given()
                .pathParam("query", query);

    }
}
