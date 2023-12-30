package starter.dummyJSON;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DummyJsonGetAllProductsAPI {
    public static String GET_ALL_PRODUCT = Constants.BASE_URL+ "/products";
    public static String GET_ALL_PRODUCT_INVALID = Constants.BASE_URL+ "/productsssss";

    @Step("Get all products invalid path")
    public void GetAllProductInvalidPath() {
        SerenityRest.given()
                .get(Constants.BASE_URL+ "/productsssss");
    }
}
