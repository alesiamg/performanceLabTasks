package org.example;

public class Main {
    public static void ringArray(int n, int m) {
        int result = 1; //Записываем в путь первый элеент массива равный 1

        do { // выполняются циклы с учетом условия while ниже
            if (result == 0) { //если result = 0 значит мы достигли последний элемент в массиве, просто записываем его, он равен n
                System.out.print(n);
            } else { //необходимое условие, зачем не понятно
                System.out.print(result);
            }
            result = (result + m - 1) % n; //формула нахождения первого элемента интервалов массива
            //первый элемент интервалов массива вычисляется с помощью остатка от деления, -1, т.к. первый элемент result=1 мы уже взяли
        } while (result != 1); // цикл работает пока результаты не равны 1, т.е. цикл завершается когда result=1
        System.out.println();
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        ringArray(n,m);
    }
}
