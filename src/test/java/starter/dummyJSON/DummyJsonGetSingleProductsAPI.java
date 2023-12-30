package starter.dummyJSON;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DummyJsonGetSingleProductsAPI {
    public static String GET_SINGLE_PRODUCT = Constants.BASE_URL+ "/products/{id}";
    public static String GET_SINGLE_PRODUCT_INVALID = Constants.BASE_URL+ "/products/productsssss";
    @Step("Get single products")
    public void getSingleProducts(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
}
