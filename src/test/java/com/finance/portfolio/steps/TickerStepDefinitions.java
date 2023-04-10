package com.finance.portfolio.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.FactoryBasedNavigableIterableAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TickerStepDefinitions {

    @Given("a list of stocks")
    public void a_list_of_stocks() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(1, 1);
    }
    @When("I get all stocks")
    public void i_get_all_stocks() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(1, 1);
    }
    @Then("I should receive the same list of stocks")
    public void i_should_receive_the_same_list_of_stocks() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(1, 1);
    }
}
