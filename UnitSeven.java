package ru.stepina.UnitSeven;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import java.util.Scanner;

public class UnitSeven {

    public static void run(Scanner scanner) {
        System.out.println("Возведение в степень");
        System.out.println("Введите два целых числа:");
        System.out.println("  X — основание");
        System.out.println("  Y — показатель степени");

        String xStr = readInput(scanner, "Основание X: ");
        String yStr = readInput(scanner, "Степень Y: ");

        try {
            double result = power(xStr, yStr);
            System.out.printf("Результат: %s ^ %s = %.6f%n", xStr, yStr, result);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: введённые значения должны быть целыми числами.");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Неизвестная ошибка: " + e.getMessage());
        }
    }

    private static double power(String xStr, String yStr) {
        int x = parseInt(xStr.trim());
        int y = parseInt(yStr.trim());

        if (x == 0 && y < 0) {
            throw new IllegalArgumentException("Нельзя возводить 0 в отрицательную степень.");
        }

        return Math.pow(x, y);
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Не удалось распознать число: " + str);
        }
    }

    private static String readInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (input.trim().isEmpty()) {
            System.out.print("Ввод не может быть пустым. " + prompt);
            input = scanner.nextLine();
        }
        return input;
    }
}