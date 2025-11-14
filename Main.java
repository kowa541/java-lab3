import ru.stepina.UnitOneOne.UnitOneOne;
import ru.stepina.UnitOneTwo.UnitOneTwo;
import ru.stepina.UnitTwo.UnitTwo;
import ru.stepina.UnitThree.UnitThree;
import ru.stepina.UnitFour.UnitFour;
import ru.stepina.UnitFive.UnitFive;
import ru.stepina.UnitSix.UnitSix;
import ru.stepina.UnitOct.UnitOct;
import ru.stepina.UnitSeven.UnitSeven;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        System.out.println("Лабораторная 3. ООП");
        Scanner me = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Выберите задание из списка 1.4, 1.10, 2, 3, 4, 5, 6, 7, 8 или 0 для завершения");
            System.out.print("Введите Ваш выбор: ");
            String input0 = me.nextLine().trim();
            if (input0.equals("0")) {
                System.out.println("Завершение работы");
                break;
            }
            switch (input0) {
                case "1.4":
                    UnitOneOne.run(me);
                    break;
                case "1.10":
                    UnitOneTwo.run();
                    break;
                case "2":
                    UnitTwo.run();
                    break;
                case "3":
                    UnitThree.run(me);
                    break;
                case "4":
                    UnitFour.run(me);
                    break;
                case "5":
                    UnitFive.run(me);
                    break;
                case "6":
                    UnitSix.run();
                    break;
                case "7":
                    UnitSeven.run(me);
                    break;
                case "8":
                    UnitOct.run();
                    break;
                default:
                    System.out.println("Нет такого номера");
                    break;

            }

        }
    }
}