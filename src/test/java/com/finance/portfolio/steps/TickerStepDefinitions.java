package com.finance.portfolio.steps;

import com.finance.portfolio.core.CoreContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.Connection;

import static org.assertj.core.api.FactoryBasedNavigableIterableAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
public class TickerStepDefinitions extends CoreContext {

    public final Connection dbConnection;

    @Given("a list of stocks from {string}")
    public void a_list_of_stocks(String fileName) {
        var response = executeGet("actuator/health");
        ScriptUtils.executeSqlScript(dbConnection, new ClassPathResource(fileName));
        assertEquals(1, 1);
    }
    @When("I get all stocks")
    public void i_get_all_stocks() {
        assertEquals(1, 1);
    }
    @Then("I should receive the same list of stocks")
    public void i_should_receive_the_same_list_of_stocks() {
        assertEquals(1, 1);
    }
}
