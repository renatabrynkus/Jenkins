package models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestScenario {
    Map<String, TestScenarioModel> testScenarios = new HashMap<>();

    @JsonAnyGetter
    public Map <String, TestScenarioModel> getTestScenarios() {
        return testScenarios;
    }

    @JsonAnySetter
    void setTestScenario(String key, TestScenarioModel value) {
        testScenarios.put(key, value);
    }

    public List<TestScenarioModel> getListOfTestScenarios() {
        List<TestScenarioModel> listOfTestScenarios = new ArrayList<TestScenarioModel>(testScenarios.values());
        return listOfTestScenarios;
    }
}
