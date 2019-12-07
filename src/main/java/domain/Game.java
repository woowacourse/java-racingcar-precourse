package domain;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    static final int MIN_CAR_NAME_LENGTH = 1;
    static final int MAX_CAR_NAME_LENGTH = 5;
    Scanner scanner;
    ArrayList<Car> cars;
    int turns;

    private String[] getUserInputCarNames() {
        String userInput;
        String[] nameArray;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        userInput = scanner.nextLine();
        nameArray = userInput.split(",");

        return nameArray;
    }

    private boolean checkUserInput(String[] inputArray) {
        for (int i=0; i<inputArray.length; i++) {
            if (!checkStringLength(inputArray[i], MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH)) {
                return false;
            }
            Car car = new Car(inputArray[i]);
            cars.add(car);
        }
        return true;
    }

    private boolean checkStringLength(String string, int min, int max) {

        if ((min <= string.length()) && (string.length() <= max)) {
            return true;
        }
        return false;
    }

    private boolean getUserInputTurns() {
        String userInput;
        userInput = scanner.nextLine();

        //문자 체크

        //음수 체크

        //0 체크

        this.turns = Integer.parseInt(userInput);
        return true;
    }

    private boolean checkInputContainsChar(String input) {
        try {
            Integer.parseInt(input);
        } catch ( NumberFormatException e) {
            System.out.print("잘못된 입력입니다.\n다시 ");
            return false;
        }
        return true;
    }

    private boolean checkInputIsMinus(String input) {
        int inputValue = Integer.parseInt(input);
        if (inputValue < 0) {
            System.out.print("음수가 입력되었습니다.\n다시 ");
            return true;
        }
        return false;
    }

    private boolean checkInputIsZero(String input) {
        int inputValue = Integer.parseInt(input);
        if (inputValue == 0) {
            System.out.print("0이 입력되었습니다.\n다시 ");
            return true;
        }
        return false;
    }

}
