package ru.stepina.UnitOneTwo;
import java.util.Map;

public class UnitOneTwo {
    public static void run() {
        System.out.println("Сущность Город (Название, пути)\n");

        BetterCity cityA = new BetterCity("A", Map.of("B", 5, "D", 6, "F", 1));
        BetterCity cityB = new BetterCity("B", Map.of("A", 5, "C", 3));
        BetterCity cityC = new BetterCity("C", Map.of("B", 3, "D", 4));
        BetterCity cityD = new BetterCity("D", Map.of("C", 4, "E", 2, "A", 6));
        BetterCity cityE = new BetterCity("E", Map.of("F", 2));
        BetterCity cityF = new BetterCity("F");

        System.out.println();
        System.out.println(cityA);
        System.out.println(cityB);
        System.out.println(cityC);
        System.out.println(cityD);
        System.out.println(cityE);
        System.out.println(cityF);


        System.out.println();
        System.out.println("Попытка добавить дорогу из A в A");
        System.out.println("До: " + cityA);
        cityA = cityA.addRoad("A", 10);
        System.out.println("После попытки добавить A→A: " + cityA);


        System.out.println();
        System.out.println("Попытка добавить дорогу с отрицательным расстоянием");
        try {
            cityA = cityA.addRoad("X", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }
        System.out.println("Состояние A не изменилось: " + cityA);


        System.out.println();
        System.out.println("Добавление уже существующей дороги A → B (была 5, станет 8)");
        System.out.println("До: " + cityA);
        cityA = cityA.addRoad("B", 8);
        System.out.println("После: " + cityA);
        System.out.println("Дорога A→B теперь имеет длину 8");


        System.out.println();
        System.out.println("Добавление новой дороги A → E дважды");
        System.out.println("До: " + cityA);
        cityA = cityA.addRoad("E", 7);
        System.out.println("Добавили A→E(7): " + cityA);
        cityA = cityA.addRoad("E", 7);
        System.out.println("Повторное добавление A→E(7): " + cityA);


        System.out.println();
        System.out.println("Удаление несуществующей дороги A → Z");
        System.out.println("До: " + cityA);
        cityA = cityA.removeRoad("Z");
        System.out.println("После удаления A→Z: " + cityA);


        System.out.println();
        System.out.println("Удаление существующей дороги A → F");
        System.out.println("До: " + cityA);
        cityA = cityA.removeRoad("F");
        System.out.println("После удаления A→F: " + cityA);


        System.out.println();
        System.out.println("Проверка дорог");
        System.out.println("A имеет дорогу в B? " + cityA.hasRoadTo("B"));
        System.out.println("A имеет дорогу в F? " + cityA.hasRoadTo("F"));
        System.out.println("Расстояние A→B: " + cityA.getDistanceTo("B"));
        System.out.println("Расстояние A→F: " + cityA.getDistanceTo("F"));


    }
}
