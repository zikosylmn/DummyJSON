package starter.dummyJSON;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class DummyJsonLoginAPI {

    public static String LOGIN_USER = Constants.BASE_URL + "/auth/login";

    @Step("Login user & get token")
    public void loginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
