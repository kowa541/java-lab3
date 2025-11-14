package ru.stepina.UnitOct;

public class UnitOct {
    public static void run() {

        Point p1 = new Point(1.5, 2.7);
        Point p2 = new Point(-3.0, 4.2);
        Point p3 = new Point(0.0, -1.1);


        System.out.println("Оригинальные точки:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        Point p1Clone = p1.clone();
        Point p2Clone = p2.clone();
        Point p3Clone = p3.clone();


        System.out.println("\nКлонированные точки:");
        System.out.println(p1Clone);
        System.out.println(p2Clone);
        System.out.println(p3Clone);
    }
}
