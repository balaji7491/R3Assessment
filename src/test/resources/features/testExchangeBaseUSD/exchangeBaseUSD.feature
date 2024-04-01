@Exchange
Feature: Verify exchange rate APIs with base USD.


  @USD
  Scenario Outline: Verify v6 latest USD endpoint
    Given Verify USD endpoint is working
    And Verify that the status code is <success_status> and result is "<result>"
    And Verify that Json schema is matching with the response body
    And Verify that the base code is received as USD
    Given Verify that the API is getting the response within <max_time_limit> seconds
    And Verify that the size of the response is within 1MB
    Then Verify that the rates is instance of Map objects
    Then Verify that the rates currency list count is equals to <total_currency_list>.
    Then Verify that the rates for AED is present and the range is between <min_range> and <max_range>

    Examples:
      | success_status | result  | max_time_limit | total_currency_list | min_range | max_range |
      | 200            | success | 3000           | 162                 | 3.6       | 3.7       |