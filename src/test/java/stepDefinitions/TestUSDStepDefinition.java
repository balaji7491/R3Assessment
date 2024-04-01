package stepDefinitions;

import exchange.v6.testUSD.TestUSD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class TestUSDStepDefinition extends TestUSD {

    @Given("Verify USD endpoint is working")
    public void verify_usd_endpoint_is_working() {
        testUSDEndpoint();
    }

    @Given("Verify that the status code is {int} and result is {string}")
    public void verify_that_the_status_code_is_and_result_is_success(Integer successStatus, String result) {
        testStatusResultIsSuccess(successStatus, result);
    }

    @Then("Verify that Json schema is matching with the response body")
    public void verifyThatJsonSchemaIsMatchingWithTheResponseBody() throws IOException {
        testSchemaValidation();
    }

    @Given("Verify that the base code is received as USD")
    public void verify_that_the_base_code_is_received_as_usd() {
        testBaseCode();
    }

    @Given("Verify that the API is getting the response within {int} seconds")
    public void verify_that_the_api_is_getting_the_response_within_seconds(Integer maxResponse) {
        testResponseTimeValidation(maxResponse);
    }

    @Given("Verify that the size of the response is within 1MB")
    public void verify_that_the_size_of_the_response_is_within_1mb() {
        responseSizeValidation();
    }

    @Then("Verify that the rates is instance of Map objects")
    public void verify_that_the_rates_is_instance_of_map_objects() {
        testRatesObject();
    }

    @Then("Verify that the rates currency list count is equals to {int}.")
    public void verify_that_the_rates_currency_list_count_is_equals_to(Integer totalCount) {
        testCurrencyListCountForBaseUSD(totalCount);
    }

    @Then("Verify that the rates for AED is present and the range is between {double} and {double}")
    public void verify_that_the_rates_for_aed_is_present_and_the_range_is_between_and(Double min, Double max) {
        testCheckUSDPriceAgainstAED(min, max);
    }

}
