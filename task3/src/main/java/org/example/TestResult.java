package org.example;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.HashMap;

public class TestResult {
    @SerializedName("id")
    public int id;
    @SerializedName("title")
    public String title;
    @SerializedName("value")
    public String value;
    @SerializedName("values")
    public TestResult[] values;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TestResult[] getValues() {
        return values;
    }

    public void setValues(TestResult[] values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);

    }
    public void setValueFromMap(HashMap<Integer,String> val) {
        this.value = val.get(this.id);
        if(this.values != null) {
            for (TestResult testResult : this.values) {
                testResult.setValueFromMap(val);

            }
        }


    }
}

