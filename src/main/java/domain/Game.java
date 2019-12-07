package domain;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    static final int MIN_CAR_NAME_LENGTH = 1;
    static final int MAX_CAR_NAME_LENGTH = 5;
    Scanner scanner;
    ArrayList<Car> cars;
    ArrayList<Car> winners;
    int turns;
    int winnerDistance;

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
            this.cars.add(car);
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

        if (checkInputIsInvalid(userInput)) {
            return false;
        }
        this.turns = Integer.parseInt(userInput);
        return true;
    }

    private boolean checkInputIsInvalid(String input) {
        if (checkInputContainsChar(input)) {
            return true;
        }
        if (checkInputIsMinus(input)) {
            return true;
        }
        if (checkInputIsZero(input)) {
            return true;
        }
        return false;
    }

    private boolean checkInputContainsChar(String input) {
        try {
            Integer.parseInt(input);
        } catch ( NumberFormatException e) {
            System.out.print("잘못된 입력입니다.\n다시 ");
            return true;
        }
        return false;
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

    private void findWinnerDistance() {
        int longestDistance = -1;
        int tempDistance;

        for (int i=0; i<this.cars.size(); i++) {
            tempDistance = cars.get(i).getPosition();
            if (tempDistance > longestDistance) {
                longestDistance = tempDistance;
            }
        }

        this.winnerDistance = longestDistance;
    }

    private void findWinner() {
        Car car;
        int distance;

        for (int i=0; i<this.cars.size(); i++) {
            car = this.cars.get(i);
            distance = car.getPosition();
            if (distance == this.winnerDistance) {
                this.winners.add(car);
            }
        }
    }
}
