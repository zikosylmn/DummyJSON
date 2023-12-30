package starter.dummyJSON;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DummyJsonDeleteCartAPI {
    public static String DELETE_CARTS = Constants.BASE_URL + "/carts/{id}";
    public static String INVALID_DELETE_CARTS = Constants.BASE_URL + "/carts/{chara}";

    @Step("Delete a cart")
    public void deleteCart(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Delete a cart invalid")
    public void deleteCartInvalid(String chara){
        SerenityRest.given()
                .pathParam("chara", chara);
    }
}
