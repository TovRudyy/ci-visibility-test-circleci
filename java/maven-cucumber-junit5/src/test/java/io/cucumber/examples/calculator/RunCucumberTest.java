package io.cucumber.examples.calculator;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/**
 * Work around. Surefire does not use JUnits Test Engine discovery
 * functionality. Alternatively execute the
 * org.junit.platform.console.ConsoleLauncher with the maven-antrun-plugin.
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("io/cucumber/examples/calculator")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "io.cucumber.examples.calculator")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "not @Disabled")
public class RunCucumberTest {

}
