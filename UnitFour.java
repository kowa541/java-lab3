package ru.stepina.UnitFour;
import java.util.Scanner;

public class UnitFour {

    public static void run(Scanner scanner) {
        try {
            System.out.println("Калькулятор дробей");
            System.out.println("Формат: введите дробь, затем операцию (+, -, *, /, =).");

            Fraction current = createFraction(scanner);

            while (true) {
                System.out.print("Введите операцию (+, -, *, /, =): ");
                String sign = scanner.nextLine().trim();

                if (sign.equals("=")) {
                    System.out.println("\n Финальный результат ");
                    printResultWithFormats(current);
                    break;
                }

                if (!isValidOperation(sign)) {
                    System.out.println("Неверный знак. Допустимые операции: +, -, *, /, =");
                    continue;
                }

                Fraction next = createFraction(scanner);
                Fraction result = performOperation(current, next, sign);

                System.out.println();
                System.out.println(current + " " + sign + " " + next + " = " + result);
                printResultWithFormats(result);
                System.out.println();


                current = result;
            }

        } catch (Exception e) {
            System.err.println("Неожиданная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean isValidOperation(String op) {
        return "+".equals(op) || "-".equals(op) || "*".equals(op) || "/".equals(op) || "=".equals(op);
    }

    private static Fraction performOperation(Fraction a, Fraction b, String op) {
        return switch (op) {
            case "+" -> a.plus(b);
            case "-" -> a.minus(b);
            case "*" -> a.times(b);
            case "/" -> {
                if (b.getNumer() == 0) {
                    throw new ArithmeticException("Деление на ноль.");
                }
                yield a.divide(b);
            }
            default -> throw new IllegalArgumentException("Неподдерживаемая операция: " + op);
        };
    }

    private static Fraction createFraction(Scanner scanner) {
        int numer = 0;
        int denom = 1;

        while (true) {
            try {
                System.out.print("Числитель: ");
                String inputNumer = scanner.nextLine().trim();
                if (inputNumer.isEmpty()) {
                    System.out.println("Числитель не может быть пустым.");
                    continue;
                }
                numer = Integer.parseInt(inputNumer);

                System.out.print("Знаменатель: ");
                String inputDenom = scanner.nextLine().trim();
                if (inputDenom.isEmpty()) {
                    System.out.println("Знаменатель не может быть пустым.");
                    continue;
                }
                denom = Integer.parseInt(inputDenom);

                return new Fraction(numer, denom);

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }


    private static void printResultWithFormats(Fraction fraction) {
        System.out.printf("Fraction: %s%n", fraction);
        System.out.printf("intValue():    %d%n", fraction.intValue());
        System.out.printf("longValue():   %d%n", fraction.longValue());
        System.out.printf("floatValue():  %.8f%n", fraction.floatValue());
        System.out.printf("doubleValue(): %.16f%n", fraction.doubleValue());
    }
}