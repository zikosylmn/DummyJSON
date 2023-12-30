package starter.dummyJSON;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class DummyJsonAddProductsAPI {

    public static String POST_ADD_PRODUCTS = Constants.BASE_URL+"/products/add";
    @Step("Post add products")
    public void postAddProducts(File json)
    {
        //langkah untuk membuat post create new user
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
