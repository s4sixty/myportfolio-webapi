Feature: Tickers functional tests


  Scenario: Retrieve all stocks
    Given a list of stocks from "stocks-data.sql"
    When I get all stocks
    Then I should receive the same list of stocks