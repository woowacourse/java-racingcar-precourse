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
        checkValidCarName(userInput);
        setCarInformation(userInput);
    }

    private static void getTrialInput(Scanner scanner) {
        System.out.println(ENTER_NUMBER_OF_TRIAL);
        String userInput = scanner.nextLine();
        checkValidNumberOfTrial(userInput);
        setNumberOfTrial(userInput);
    }


    //예외처리
    private static void checkValidCarName(String userInput) {
        String[] cars = userInput.split(",");
        for (String car : cars) {
            try {
                if (car.equals("")) {
                    throw new UserInputException();
                }
                if (car.length() > 5) {
                    throw new UserInputException();
                }
            } catch (UserInputException e) {
                System.err.println(ERROR_CAR_NAME);
                break;
            }
        }
    }

    private static void checkValidNumberOfTrial(String userInput) {
        int checkConvertAvailable;
        try {
            checkConvertAvailable = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.err.println(ERROR_TRIAL_NUMBER);
        }
    }

    private static void setNumberOfTrial(String userInput) {
        numberOfTrial = Integer.parseInt(userInput);
    }

    public static int getNumberOfCarsInGame() {
        return numberOfCarsInGame;
    }

    public static int getNumberOfTrial() {
        return numberOfTrial;
    }

    //return array
    public static ArrayList getCarsArray() {
        return carsInGame;
    }


    private static void setCarInformation(String userInput) {
        String[] cars = userInput.split(",");
        numberOfCarsInGame = cars.length;
        for (int i = 0; i < numberOfCarsInGame; i++) {
            carsInGame.add(new Car(cars[i]));
        }
    }
}
