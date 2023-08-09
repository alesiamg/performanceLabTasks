package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    //проверка точки (x, y) относительно окружности с центром (cx, cy) и радиусом rds
    public static void pointOnCircle(float cx, float cy, float rds, float x, float y) {
        //формула уравнения окружности:  (x - cx)^2 + (y - cy)^2 = r^2,
        //s = 0
        double s = ((x - cx) * (x - cx)) + ((y - cy) * (y - cy)) - (rds * rds);
        if (s < 0)
            System.out.println("1");
        else if (s > 0)
            System.out.println("2");
        else
            System.out.println("0"); //точка лежит на границе окружности

    }

    public static void main(String[] args) {
        Path circleInfo = Paths.get(args[0]); //Создается объект Path для файла circleInfo,
        // который является путем к файлу, переданному в аргументе командной строки args[0].
        Path points = Paths.get(args[1]);
        float xcenter;
        float ycenter;
        float radius;
        //обработка исключений при работе с файлами и обработка необходимой логики
        try (Scanner sc = new Scanner(circleInfo.toFile())) { //Создается объект Scanner для чтения файла circleInfo.
            String[] centrePointSt = sc.nextLine().split(" "); //Считывается первая строка файла circleInfo,
            // которая содержит координаты центра окружности и радиус, и она разбивается на подстроки по пробелам
            // с помощью метода split(" ").
            // Результат разбиения хранится в массиве centrePointSt.
            xcenter = Float.parseFloat(centrePointSt[0]); //Значения координат xcenter и ycenter из массива centrePointSt преобразуются
            // из строкового формата в числовой формат типа float с помощью метода Float.parseFloat().
            ycenter = Float.parseFloat(centrePointSt[1]);
            radius = sc.nextFloat(); //Значение радиуса radius считывается с помощью метода sc.nextFloat().

            //Если возникнет исключение при чтении или преобразовании данных, исключение будет поймано в блоке catch.
            // В этом случае будет выведено сообщение об ошибке, и программа будет завершена.
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        try (Scanner sc = new Scanner(points.toFile())) {
            while (sc.hasNext()) { //в цикле while будут считываться строки из файла points, пока они есть.
                String[] point = sc.nextLine()
                        .split(" "); //Каждая считанная строка разбивается на подстроки по пробелам с
                // помощью метода split(" "), и результат разбиения хранится в массиве point.

                float x = Float.parseFloat(point[0]);
                float y = Float.parseFloat(point[1]);

                pointOnCircle(xcenter, ycenter, radius, x, y);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

