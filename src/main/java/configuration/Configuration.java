package configuration;

import models.Browser;
import models.TestScenario;

public class Configuration {
    public TestScenario testScenario;
    public Browser browser;

    public TestScenario getEnvironment() {
        return testScenario;
    }

    public Browser getBrowser() {
        return browser;
    }
}
