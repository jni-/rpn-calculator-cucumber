package ca.ulaval.glo4002.rpn_calculator.uat;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "classpath:rpn/")
public class RpnCucumberTest {

}
