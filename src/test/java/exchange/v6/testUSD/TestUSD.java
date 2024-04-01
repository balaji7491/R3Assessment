package exchange.v6.testUSD;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.encoders.UTF8;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;
import restProtocol.Base;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class TestUSD extends Base {

    String servicePath = "/v6/latest";
    Response response;
    long MaxResponseTime = 3000L;

    @Override
    protected String getServicePath() {
        return servicePath;
    }


    public void testUSDEndpoint(){
        response = get("/USD");
    }

    @Test
    public void testStatusResultIsSuccess(Integer code, String result){
        assert response.path("result").equals(result): "result validation failed";
    }

    @Test
    public void testResponseTimeValidation(int maxResponseTime){
        assert response.time() <= maxResponseTime: "Response took longer then 3 seconds";
    }

    @Test
    public void responseSizeValidation(){
        var sizeInKB = response.getBody().asByteArray().length / 1024.0;
        assert sizeInKB <= 1024: "Body data size is more then 1MB"; // Ensure data size is less then 1MB
    }

    @Test
    public void testUSDEndpointProvider(){
        String expectedProvider = "https://www.exchangerate-api.com";
        var actualProvider = response.path("provider");
        assert actualProvider.equals(expectedProvider) :
                "Actual provider: "+actualProvider+" in the response is not matched with expected provider: "+expectedProvider;
    }

    @Test
    public void testBaseCode(){
        String baseCode = response.path("base_code");
        assert baseCode.equals("USD"): "Base code is not USD";

    }

    @Test
    public void testRatesObject(){
        Map<String, Float> rates = response.path("rates");
        assert (rates instanceof HashMap<String, Float>);
    }

    @Test
    public void testCurrencyListCountForBaseUSD(Integer listCount){
        Map<String, Float> rates = response.path("rates");
        assert rates.size() >= listCount;
    }

    @Test
    public void testCheckUSDPriceAgainstAED(Double minRange, Double maxRange){
        Float AEDPrice = response.path("rates.AED");
        assert (minRange <= AEDPrice) && ( AEDPrice <= maxRange);
    }

    @Test
    public void testSchemaValidation() throws IOException {
        String jsonSchemaString = FileUtils.readFileToString(new File("src/test/resources/schemas/ExchangeSchemaBaseUSD.json"), "UTF-8");
        schemaValidation(servicePath, "/USD",jsonSchemaString);
    }


}
