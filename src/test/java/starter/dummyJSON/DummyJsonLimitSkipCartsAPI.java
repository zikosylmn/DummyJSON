package starter.dummyJSON;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DummyJsonLimitSkipCartsAPI {
    public static String LIMIT_SKIP_CARTS = Constants.BASE_URL + "/carts?limit={limit}&skip={skip}&select=id,title";
    public static String INVALID_LIMIT_SKIP_CARTS = Constants.BASE_URL + "/carts?limit={chara}&skip={skip}&select=id,title";

    @Step("Limit & skip carts")
    public void limitSkipCarts(int limit,int skip){
        SerenityRest.given()
                .pathParam("limit", limit)
                .pathParam("skip", skip);
    }
    @Step("Limit & skip carts invalid")
    public void limitSkipCartsInvalid(String chara, int skip){
        SerenityRest.given()
                .pathParam("chara", chara)
                .pathParam("skip", skip);
    }
}
