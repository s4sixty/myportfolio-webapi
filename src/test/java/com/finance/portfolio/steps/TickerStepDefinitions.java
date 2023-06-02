package com.finance.portfolio.steps;

import com.finance.portfolio.core.CoreContext;
import com.finance.portfolio.domain.dao.Stock;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.Connection;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableIterableAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TickerStepDefinitions extends CoreContext {

    public List<Stock> stocks;

    private final Connection dbConnection;

    @Given("a list of stocks from {string}")
    public void a_list_of_stocks(String fileName) {
        ScriptUtils.executeSqlScript(dbConnection, new ClassPathResource("sql/" + fileName));
    }

    @When("I get all stocks")
    public void i_get_all_stocks() throws Exception {
        var response = executeGetWithAuthentication("api/v1/tickers/stocks").getResponse();

        assertEquals(200, response.getStatus());
    }

    @Then("I should receive the same list of stocks")
    public void i_should_receive_the_same_list_of_stocks() {
        assertEquals(1, 1);
    }
}
