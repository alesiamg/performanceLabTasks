package org.example;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.HashMap;

public class Tests {
    @SerializedName("tests")
    public TestResult[] tests;

    public TestResult[] getTests() {
        return tests;
    }

    public void setTests(TestResult[] tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);

    }
    public void setValues(HashMap<Integer,String> values) {
        for (TestResult test : tests) {
            test.setValueFromMap(values);

        }

    }

}
