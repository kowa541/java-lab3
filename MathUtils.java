package ru.stepina.UnitFive;

import java.util.List;

public class MathUtils {

    public static double sum(List<? extends Number> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (Number num : numbers) {
            if (num != null) {
                total += num.doubleValue();
            }
        }
        return total;
    }
}
