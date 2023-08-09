package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;


public class Main {


    public static void main(String[] args) throws Exception {
        Gson gs = new GsonBuilder().create(); // созданы параметры, которые будут вычитываться
        // при вычитке из джсон

        try (Reader readTest = new FileReader(args[0]); //создались дескрипторы
             Reader readValues = new FileReader(args[1]);
             JsonReader jst = gs.newJsonReader(readTest);//создан объект для чтения из файла
             Writer writer = new FileWriter("report.json");
             JsonReader jsr = gs.newJsonReader(readValues)) {

            Values values = gs.fromJson(jsr, Values.class); //засовываем данные из ридера в объект класса
//            System.out.println(values.getMapValues());
//            System.out.println(values.values[0].id);

            Tests test = gs.fromJson(jst, Tests.class);

            test.setValues(values.getMapValues());
//            System.out.println(new Gson().toJson(test));

            gs.toJson(test, writer);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
