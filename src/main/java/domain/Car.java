package domain;

import java.util.Scanner;
import java.util.InputMismatchException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Car {
    private final String name;
    private int position = 0;

    Car(final String name) {
        this.name = name;
    }
}

class GameManager {
    private static final Scanner input = new Scanner(System.in);
    private static Car[] cars;
    private static int numbersToTry;

    public static void main(String args[]) {
        inputNames();
        inputNumbers();
    }

    private static void inputNames() {
        String lineInput;
        String[] names;

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            lineInput = input.nextLine();
            names = lineInput.split(",");
            if (lineInput.length() == 0 || !checkLengthsOfNames(names)) {
                System.out.println("잘못된 입력입니다. 이름은 5글자 이하여야 합니다.");
                input.next();
                continue;
            }
            addCars(names);
            break;
        }
    }

    private static boolean checkLengthsOfNames(final String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    private static void addCars(final String[] names) {
        cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
    }

    private static void inputNumbers() {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                numbersToTry = input.nextInt();
                if (numbersToTry <= 0) {
                    throw new Error();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                input.next();
                continue;
            }
        }
    }
}