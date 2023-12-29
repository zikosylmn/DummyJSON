package starter.dummyJSON;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DummyJsonGetSingleCartsAPI {
    public static String GET_SINGLE_CARTS = Constants.BASE_URL + "/carts/{id}";
    public static String INVALID_GET_SINGLE_CARTS = Constants.BASE_URL + "/carts/{chara}";

    @Step("Get a single carts")
    public void getSingleCarts(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get a single carts invalid")
    public void getSingleCartsInvalid(String chara){
        SerenityRest.given()
                .pathParam("chara", chara);
    }

}
