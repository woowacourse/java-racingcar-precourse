package racingcar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class GameInformation {
    private static int numberOfCarsInGame;
    private static int numberOfTrial;
    private static ArrayList<Car> carsInGame = new ArrayList<Car>();

    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_NUMBER_OF_TRIAL = "시도할 회수는 몇회인가요?";
    private static final String ERROR_CAR_NAME = "[ERROR] 경주할 자동차 이름이 올바르게 입력되지 않았습니다.";
    private static final String ERROR_TRIAL_NUMBER = "[ERROR] 시도 횟수는 숫자여야 한다.";

    //return String
    public static void getUserInput(Scanner scanner) {
        getCarInput(scanner);
        getTrialInput(scanner);
    }

    private static void getCarInput(Scanner scanner) {
        System.out.println(ENTER_CAR_NAME);
        String userInput = scanner.nextLine();
        String[] cars = checkValidCarNameInput(userInput);
        setCarInformation(cars);
    }

    private static String[] checkValidCarNameInput(String userInput) {
        String[] cars = userInput.split(",");
        for (String car : cars) {
            checkEachCarName(car);
        }
        return cars;
    }

    private static void checkEachCarName(String car) {
        try {
            if ((car.length() == 0) || (car.length() > 5)) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            System.err.println(ERROR_CAR_NAME);
            System.exit(0);
        }
    }

    private static void setCarInformation(String cars[]) {
        numberOfCarsInGame = cars.length;
        for (int i = 0; i < numberOfCarsInGame; i++) {
            carsInGame.add(new Car(cars[i]));
        }
    }

    private static void getTrialInput(Scanner scanner) {
        System.out.println(ENTER_NUMBER_OF_TRIAL);
        String userInput = scanner.nextLine();
        int trialInput = checkValidNumberOfTrial(userInput);
        setNumberOfTrial(trialInput);
    }

    private static int checkValidNumberOfTrial(String userInput) {
        int trialInput = 0;
        try {
            trialInput = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.err.println(ERROR_TRIAL_NUMBER);
            System.exit(0);
        }
        return trialInput;
    }

    private static void setNumberOfTrial(int trialInput) {
        numberOfTrial = trialInput;
    }

    public static int getNumberOfCarsInGame() {
        return numberOfCarsInGame;
    }

    public static int getNumberOfTrial() {
        return numberOfTrial;
    }

    public static ArrayList getCarsInGame() {
        return carsInGame;
    }
}
