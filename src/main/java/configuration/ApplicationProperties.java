package configuration;

import models.Browser;
import models.TestScenarioModel;

import java.util.List;
import java.util.Map;

public class ApplicationProperties {

    YamlReader yamlReader = new YamlReader();
    private Browser browser;
    private List<TestScenarioModel> listOfTestScenarios;

    public ApplicationProperties() {
        setBrowserProperties();
        setTestScenarioProperties();
    }

    public static ApplicationProperties getInstance() {
        return ApplicationPropertiesSingleton.INSTANCE;
    }

    private void setTestScenarioProperties() {
        listOfTestScenarios = yamlReader.getConfig().getEnvironment().getListOfTestScenarios();
        boolean foundActiveEnvironment = false;
        for (TestScenarioModel testScenarioModel : listOfTestScenarios) {
            if (testScenarioModel.isActive()) {
                foundActiveEnvironment = true;
                Map<String, Object> environmentProperties = testScenarioModel.getProperties();
                for (Map.Entry entry : environmentProperties.entrySet()) {
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                }
                break;
            }
        }
    }

    private void setBrowserProperties() {
        browser = yamlReader.getConfig().getBrowser();
        Map<String, Object> browserProperties = browser.getBrowserProperties();
        for (Map.Entry entry : browserProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }
    }

    private static class ApplicationPropertiesSingleton {
        private static final ApplicationProperties INSTANCE = new ApplicationProperties();
    }
}
