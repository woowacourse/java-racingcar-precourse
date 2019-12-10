package domain;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class Game {
    static final int MIN_CAR_NAMES_COUNT = 1;
    static final int MIN_CAR_NAME_LENGTH = 1;
    static final int MAX_CAR_NAME_LENGTH = 5;

    static final String MESSAGE_ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String MESSAGE_ASK_TURNS = "시도할 회는 몇회인가요?";
    static final String MESSAGE_RESULT_OF_RACE = "실행 결과";
    static final String MESSAGE_IS_WINNER = "가 최종우승 했습니다.";

    static final String ERROR_MESSAGE_AGAIN = "다시 ";
    static final String ERROR_MESSAGE_CAR_NAME_IS_NOT_ENTERED = "입력된 자동차 이름이 없습니다.";
    static final String ERROR_MESSAGE_CAR_NAME_IS_DUPLICATED = "중복된 자동차 이름이 있습니다.";
    static final String ERROR_MESSAGE_CAR_NAME_LENGTH_IS_WRONG = "자동차 이름의 길이가 잘못되었습니다.";
    static final String ERROR_MESSAGE_INPUT_CONTAINS_CHAR = "문자가 입력되었습니다. 다시 입력해주세요.";
    static final String ERROR_MESSAGE_INPUT_VALUE_IS_MINUS = "음수가 입력되었습니다. 다시 입력해주세요.";
    static final String ERROR_MESSAGE_INPUT_VALUE_IS_ZERO = "0이 입력되었습니다. 다시 입력해주세요.";

    Scanner scanner;
    ArrayList<Car> cars;
    ArrayList<Car> winners;
    int turns;
    int winnerDistance;

    public Game() {
        this.scanner = new Scanner(System.in);
        this.cars = new ArrayList<Car>();
        this.winners = new ArrayList<Car>();
    }

    public void start() {

        initializeCars();
        initializeTurns();
        startRace();
        printResult();
        System.exit(0);
    }

    private void initializeCars() {
        String[] userInput;

        while (true) {
            userInput = askUserInputCarNames();
            userInput = trimUserInputCarNames(userInput);
            if (checkUserInputCarNames(userInput) == true) {
                saveCarNames(userInput);
                break;
            }
            System.out.print(ERROR_MESSAGE_AGAIN);
        }
    }

    private String[] askUserInputCarNames() {
        String userInput;
        String[] nameArray;

        System.out.println(MESSAGE_ASK_CAR_NAMES);
        userInput = scanner.nextLine();
        nameArray = userInput.split(",");

        return nameArray;
    }

    private String[] trimUserInputCarNames(String[] inputArray) {
        int arrLength = inputArray.length;
        String[] trimmedArray = new String[arrLength];

        for (int i=0; i<arrLength; i++) {
            trimmedArray[i] = inputArray[i].trim();
        }

        return trimmedArray;
    }

    private boolean checkUserInputCarNames(String[] inputArray) {
        if (!checkNumberOfString(inputArray, MIN_CAR_NAMES_COUNT)){
            return false;
        }
        for (int i=0; i<inputArray.length; i++) {
            if (!checkStringLength(inputArray[i], MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH)) {
                return false;
            }
        }
        if (checkUserInputCarNamesDuplicated(inputArray)) {
            return false;
        }
        return true;
    }

    private boolean checkNumberOfString(String[] inputArray, int minimumCount) {
        if (inputArray.length < minimumCount) {
            System.out.println(ERROR_MESSAGE_CAR_NAME_IS_NOT_ENTERED);
            return false;
        }
        return true;
    }

    private boolean checkUserInputCarNamesDuplicated(String[] inputArray) {
        HashSet<String> nameSet = new HashSet<String>();
        for (int i=0; i<inputArray.length; i++) {
            if (nameSet.contains(inputArray[i])) {
                System.out.println(ERROR_MESSAGE_CAR_NAME_IS_DUPLICATED);
                return true;
            }
            nameSet.add(inputArray[i]);
        }
        return false;
    }

    private void saveCarNames(String[] inputArray) {
        for (int i=0; i<inputArray.length; i++) {
            Car car = new Car(inputArray[i]);
            this.cars.add(car);
        }
    }

    private boolean checkStringLength(String string, int min, int max) {

        if ((min <= string.length()) && (string.length() <= max)) {
            return true;
        }
        System.out.println(ERROR_MESSAGE_CAR_NAME_LENGTH_IS_WRONG);
        return false;
    }

    private void initializeTurns() {
        while (true) {
            if (askUserInputTurns() == true) {
                break;
            }
        }
    }

    private boolean askUserInputTurns() {
        String userInput;

        System.out.println(MESSAGE_ASK_TURNS);
        userInput = scanner.nextLine();

        if (checkUserInputTurnsAreInvalid(userInput)) {
            return false;
        }
        this.turns = Integer.parseInt(userInput);
        return true;
    }

    private boolean checkUserInputTurnsAreInvalid(String input) {
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
            System.out.println(ERROR_MESSAGE_INPUT_CONTAINS_CHAR);
            return true;
        }
        return false;
    }

    private boolean checkInputIsMinus(String input) {
        int inputValue = Integer.parseInt(input);
        if (inputValue < 0) {
            System.out.println(ERROR_MESSAGE_INPUT_VALUE_IS_MINUS);
            return true;
        }
        return false;
    }

    private boolean checkInputIsZero(String input) {
        int inputValue = Integer.parseInt(input);
        if (inputValue == 0) {
            System.out.println(ERROR_MESSAGE_INPUT_VALUE_IS_ZERO);
            return true;
        }
        return false;
    }

    private void startRace() {
        Car car;
        System.out.println(MESSAGE_RESULT_OF_RACE);

        for (int i=0; i<this.turns; i++) {
            for (int j=0; j<this.cars.size(); j++) {
                car = this.cars.get(j);
                car.moveOrStop();
                car.printRoute();
            }
            System.out.println();
        }
    }

    private void printResult() {
        findWinnerDistance();
        findWinners();
        printWinners();
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
        System.out.println(getWinnersName() + MESSAGE_IS_WINNER);
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
