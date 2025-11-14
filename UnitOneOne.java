package ru.stepina.UnitOneOne;

import java.util.Scanner;

public class UnitOneOne {

    public static void run(Scanner scanner) {
        try {
            System.out.println("Калькулятор дробей");
            System.out.println("Формат: введите дробь, затем знак (+, -, *, /, =).");

            Fraction current = createFraction(scanner);

            while (true) {
                System.out.print("Введите знак (+, -, *, /, =): ");
                String sign = scanner.nextLine().trim();

                if (sign.equals("=")) {
                    System.out.println("Результат: " + current);
                    break;
                }

                if (!sign.equals("+") && !sign.equals("-") && !sign.equals("*") && !sign.equals("/")) {
                    System.out.println("Неверный знак.");
                    continue;
                }

                Fraction next = createFraction(scanner);
                Fraction result = null;

                switch (sign) {
                    case "+":
                        result = current.plus(next);
                        System.out.println(current + " + " + next + " = " + result);
                        break;
                    case "-":
                        result = current.minus(next);
                        System.out.println(current + " - " + next + " = " + result);
                        break;
                    case "*":
                        result = current.times(next);
                        System.out.println(current + " * " + next + " = " + result);
                        break;
                    case "/":
                        result = current.divide(next);
                        System.out.println(current + " / " + next + " = " + result);
                        break;
                }

                current = result;
            }

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static Fraction createFraction(Scanner scanner) {
        int numer = 0, denom = 1;

        while (true) {
            try {
                System.out.print("Числитель: ");
                String inputNumer = scanner.nextLine().trim();
                numer = Integer.parseInt(inputNumer);

                System.out.print("Знаменатель: ");
                String inputDenom = scanner.nextLine().trim();
                denom = Integer.parseInt(inputDenom);

                return new Fraction(numer, denom);

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка при создании дроби: " + e.getMessage());
            }
        }
    }
}