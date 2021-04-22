package com.ge.hc.mdi.calculatorservicecomponentbdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources",
    tags = {"@Login"},
    plugin = {"pretty", "json:target/cucumber-report.json", "html:target/cucumber-html-report"})
public class CucumberTests {}
