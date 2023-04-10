package com.finance.portfolio;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        glue={"com.finance.portfolio.steps", "com.finance.portfolio.config"},
        plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true
)
class CucumberIntegrationTests {

}
