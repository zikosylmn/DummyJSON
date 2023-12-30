package starter.dummyJSON;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class DummyJsonUpdateCartAPI {
    public static String UPDATE_CART = Constants.BASE_URL + "/carts/1";

    @Step("Update a cart")
    public void updateCart(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
