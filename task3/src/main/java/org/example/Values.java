package org.example;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.HashMap;

public class Values {
    public Result[] values;

    public Result[] getValues() {
        return values;
    }

    public void setValues(Result[] values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);

    }

    public HashMap<Integer,String> getMapValues() {
        HashMap<Integer,String> result = new HashMap<>();
        for (Result value : values) {
            result.put(value.id, value.value);
        }

        return result;
    }
}
