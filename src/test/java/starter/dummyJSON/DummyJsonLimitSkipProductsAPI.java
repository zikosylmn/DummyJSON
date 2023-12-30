package starter.dummyJSON;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DummyJsonLimitSkipProductsAPI {
    public static String LIMIT_SKIP_PRODUCTS = Constants.BASE_URL + "/products?limit=10&skip=20&select=title,price";
    public static String INVALID_LIMIT_SKIP_PRODUCTS = Constants.BASE_URL + "/products?limit={chara}&skip={skip}&select=id,title";

    @Step("Limit & skip products")
    public void limitSkipProducts(int limit,int skip){
        SerenityRest.given()
                .pathParam("limit", limit)
                .pathParam("skip", skip);
    }
    @Step("Limit & skip products invalid")
    public void limitSkipProductsInvalid(String chara, int skip){
        SerenityRest.given()
                .pathParam("chara", chara)
                .pathParam("skip", skip);
    }
}
