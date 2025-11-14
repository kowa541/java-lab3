package ru.stepina.UnitTwo;
import java.util.*;
import java.util.stream.Collectors;

public class UnitTwo {
    public static void run() {
        System.out.println("Маршрут между городами\n");

        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");


        A = A.addRoad(B).addRoad(D).addRoad(F);
        B = B.addRoad(A).addRoad(C);
        C = C.addRoad(B).addRoad(D);
        D = D.addRoad(C).addRoad(E).addRoad(A);
        E = E.addRoad(F);
        F = F.addRoad(E).addRoad(B);


        Map<City, Set<City>> graph = new HashMap<>();
        for (City city : Arrays.asList(A, B, C, D, E, F)) {
            graph.put(city, city.getRoads());
        }


        System.out.println("Ищем маршрут из F в D\n");

        try {
            Route route = new Route(graph, F, D);

            System.out.println("Маршрут: " + route);

            City[] path = route.getRoute();
            System.out.print("Массив городов: ");
            if (path.length == 0) {
                System.out.println("[]");
            } else {
                System.out.println(Arrays.stream(path)
                        .map(City::getName)
                        .collect(Collectors.toList()));
            }



        } catch (Exception e) {
            System.err.println("Ошибка при выполнении: " + e.getMessage());
        }

    }
}