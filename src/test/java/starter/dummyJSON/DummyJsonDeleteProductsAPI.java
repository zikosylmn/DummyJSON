package starter.dummyJSON;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DummyJsonDeleteProductsAPI {
    public static String DELETE_PRODUCTS = Constants.BASE_URL+"/products/{id}";
    @Step("Delete products")
    public void deleteProducts(int id)
    {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete products invalid")
    public void deleteProductsInvalid(String id)
    {
        SerenityRest.given().pathParam("id", id);
    }
}
