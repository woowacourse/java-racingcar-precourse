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

    public void start() {
        String[] userInput;
        Car car;

        //car 이름 입력 받는 부분
        while (true) {
            userInput = getUserInputCarNames();
            if (checkUserInputCarNames(userInput) == true) {
                break;
            }
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }

        //시도할 횟수 입력 받는 부분
        while (true) {
            if (getUserInputTurns() == true) {
                break;
            }
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }

        //실행 결과 부분
        System.out.println("실행 결과");
        for (int i=0; i<this.turns; i++) {
            for (int j=0; j<this.cars.size(); j++) {
                car = this.cars.get(j);
                car.moveOrStop();
                car.printRoute();
            }
            System.out.println();
        }

        //우승자 출력 부분
        findWinnerDistance();
        findWinners();
        printWinners();

        System.exit(0);
    }

    private String[] getUserInputCarNames() {
        String userInput;
        String[] nameArray;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        userInput = scanner.nextLine();
        nameArray = userInput.split(",");

        return nameArray;
    }

    private boolean checkUserInputCarNames(String[] inputArray) {
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

        System.out.println("시도할 회는 몇회인가요?");
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

    private void findWinners() {
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

    private void printWinners() {
        System.out.println(getWinnersName() + "가 최종우승 했습니다.");
    }

    private String getWinnersName() {
        int size = this.winners.size();
        Car winner;
        String winnersNames = "";

        for (int i=0; i<size-1; i++) {
            winner = this.winners.get(i);
            winnersNames += winner.getName();
            winnersNames += ", ";
        }

        winner = this.winners.get(size-1);
        winnersNames += winner.getName();
        return winnersNames;
    }
}
