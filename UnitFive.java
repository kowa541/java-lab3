package ru.stepina.UnitFive;

import java.util.*;
import java.util.regex.Pattern;

public class UnitFive {

    private static final Pattern FRACTION_PATTERN = Pattern.compile("(-?\\d+)\\s*/\\s*(\\d+)");

    public static void run(Scanner scanner) {
        System.out.println("Сложение чисел ");
        System.out.println("Введите числа по одному");
        System.out.println("Пустая строка — завершить ввод");

        List<Number> numbers = new ArrayList<>();

        while (true) {
            System.out.print("Число: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                break;
            }

            Number num = parseNumber(input);
            if (num != null) {
                numbers.add(num);
                System.out.println("Добавлено: " + num + " → как double: " + num.doubleValue());
            } else {
                System.out.println("Не удалось распознать число: '" + input + "'");
            }
        }

        double sum = sumNumbers(numbers);
        System.out.printf("\nВведено чисел: %d%n", numbers.size());
        System.out.printf("Сумма: %.6f%n", sum);
    }

    private static Number parseNumber(String input) {
        input = input.trim();


        if (FRACTION_PATTERN.matcher(input).matches()) {
            try {
                Scanner fractionScanner = new Scanner(input);
                fractionScanner.useDelimiter("\\s*/\\s*");
                int numer = fractionScanner.nextInt();
                int denom = fractionScanner.nextInt();


                if (denom == 0) {
                    System.out.println("Знаменатель не может быть нулём.");
                    return null;
                }
                return (double) numer / denom;
            } catch (Exception e) {
                System.out.println("Ошибка при парсинге дроби: " + e.getMessage());
                return null;
            }
        }

        try {
            if (input.contains(".") || input.toLowerCase().contains("e")) {
                return Double.parseDouble(input);
            } else {
                return Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }


    public static double sumNumbers(List<? extends Number> numbers) {
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
