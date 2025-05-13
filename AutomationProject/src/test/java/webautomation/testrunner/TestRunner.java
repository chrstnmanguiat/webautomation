package webautomation.testrunner;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("webautomation/features")
@ConfigurationParameter(key = "cucumber.glue", value = "webautomation.stepdefinitions")
public class TestRunner {
}