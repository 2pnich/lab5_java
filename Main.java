import java.util.Scanner;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        int option = 0, i = 0;
        basket[] bas_one = new basket[20];
        basket[][] bas_double = new basket[20][20];
        while (option != 5) {
            System.out.println("\nВвести заказ - 1");
            System.out.println("Вывести все заказы - 2");
            System.out.println("Ввести двумерный массив - 3");
            System.out.println("Вывести двумерный массив - 4");
            System.out.println("Выход - 5");
            Scanner in = new Scanner(System.in);

            /////TRY БЛОК/////
            try {
                option = in.nextInt();
                if (option > 5 || option < 1)
                    throw new OptionException("invalid range");
            } catch (InputMismatchException e) {
                System.err.println("Нужно вводить цифру!!!");
            } catch (OptionException e) {
                System.err.println("Диапазон 1-3");
            }
            ////////////////

            help res = new help();
            switch (option) {
                case (1):
                    // ОДНОМЕРНЫЙ МАССИВ ОБЪЕКТОВ //
                    shaurma _shaurma = new shaurma();
                    pizza _pizza = new pizza();
                    drink _drink = new drink();
                    soup _soup = new soup();
                    fries _fries = new fries();

                    bas_one[i] = new basket(_shaurma, _pizza, _drink, _soup, _fries);
                    bas_one[i].input();
                    bas_one[i].output();
                    bas_one[i].sum(res);
                    basket.payment(res);
                    i++;
                    basket.counter_one++;
                    break;
                case (2):
                    for (int j = 0; j < basket.counter_one; j++) {
                        bas_one[j].output();
                        bas_one[j].sum(res);
                        System.out.println("\n");
                    }
                    break;

                case(3):
                    for (int k = 0; k < 1; k++){         //ДВУМЕРНЫЙ МАССИВ ОБЪЕКТОВ//
                        for (int j = 0; j < 1; j++){
                            _shaurma = new shaurma();
                            _pizza = new pizza();
                            _drink = new drink();
                            _soup = new soup();
                            _fries = new fries();

                            bas_double[i][j] = new basket(_shaurma, _pizza, _drink, _soup, _fries);
                            bas_double[i][j].input();
                            bas_double[i][j].output();
                            bas_double[i][j].sum(res);
                            basket.payment(res);
                            basket.counter_two++;
                        }
                    }
                    break;
                case (4):
                    for (int k = 0; k < basket.counter_two; k++)
                        for (int j = 0; j < basket.counter_two; j++) {
                            bas_double[i][j].output();
                            bas_double[i][j].sum(res);
                            System.out.println("\n");
                        }
                    break;
                case (5):
                    System.exit(0);
            }
        }
    }
}