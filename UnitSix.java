package ru.stepina.UnitSix;
import java.util.*;

public class UnitSix {
    public static void run() {

        BetterCity city1 = new BetterCity("Москва");
        city1.addRoad("Тверь");
        city1.addRoad("Ярославль");
        city1.addRoad("Калуга");

        BetterCity city2 = new BetterCity("Новый Город");
        city2.addRoad("Ярославль");
        city2.addRoad("Тверь");
        city2.addRoad("Калуга");

        BetterCity city3 = new BetterCity("Санкт-Петербург");
        city3.addRoad("Тверь");
        city3.addRoad("Новгород");

        BetterCity city4 = new BetterCity("Копия Москвы");
        city4.addRoad("Калуга");
        city4.addRoad("Тверь");
        city4.addRoad("Ярославль");


        System.out.println("city1: " + city1);
        System.out.println("city2: " + city2);
        System.out.println("city3: " + city3);
        System.out.println("city4: " + city4);
        System.out.println();

        System.out.println("city1.equals(city2): " + city1.equals(city2)); // true
        System.out.println("city1.equals(city3): " + city1.equals(city3)); // false
        System.out.println("city1.equals(city4): " + city1.equals(city4)); // true
        System.out.println("city2.equals(city4): " + city2.equals(city4)); // true


    }
}