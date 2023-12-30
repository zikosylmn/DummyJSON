package starter.dummyJSON;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class DummyJsonAddCartAPI {
    public static String ADD_NEW_CART = Constants.BASE_URL + "/carts/add";

    @Step("Add a new cart")
    public void addNewCart(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
