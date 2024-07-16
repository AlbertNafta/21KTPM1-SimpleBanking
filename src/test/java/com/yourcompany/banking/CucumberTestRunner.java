package com.yourcompany.banking;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.yourcompany.banking.steps", "com.yourcompany.banking"}
)
public class CucumberTestRunner {
}