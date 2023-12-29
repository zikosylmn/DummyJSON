package starter.dummyJSON;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DummyJsonGetAllCartsAPI {
    public static String GET_ALL_CARTS = Constants.BASE_URL + "/carts";
    public static String INVALID_GET_ALL_CARTS = Constants.BASE_URL + "/allcarts";

@Step("Get all carts")
    public void getAllCarts(){
    SerenityRest.given();
}
}
