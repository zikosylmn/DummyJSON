package starter.dummyJSON;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DummyJsonCartsUserAPI {
    public static String GET_CARTS_USER = Constants.BASE_URL + "/carts/user/{id}";
    public static String INVALID_GET_CARTS_USER = Constants.BASE_URL + "/carts/user/{chara}";

    @Step("Get carts of a user")
    public void getCartsUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get carts of a user invalid")
    public void getCartsUserInvalid(String chara){
        SerenityRest.given()
                .pathParam("chara", chara);
    }
}
