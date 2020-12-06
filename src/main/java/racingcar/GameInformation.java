package racingcar;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameInformation {
    private static int numberOfCarsInGame;
    private static int numberOfTrial;
    private static ArrayList<Car> carsInGame = new ArrayList<Car>();

    private static final int MIN_CAR_NAME_LENGTH = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_NUMBER_OF_TRIAL = "시도할 회수는 몇회인가요?";
    private static final String ERROR_CAR_NAME = "[ERROR] 경주할 자동차 이름이 올바르게 입력되지 않았습니다.";
    private static final String ERROR_CAR_DUPLICATE = "[ERROR] 경주할 자동차 이름이 중복됩니다.";
    private static final String ERROR_TRIAL_NUMBER = "[ERROR] 시도 횟수는 자연수여야 합니다.";

    //return String
    public static void getUserInput(Scanner scanner) {
        getCarInput(scanner);
        getTrialInput(scanner);
    }

    private static void getCarInput(Scanner scanner) {
        System.out.println(ENTER_CAR_NAME);
        String userInput = scanner.nextLine();
        String[] cars = checkCarNameInput(userInput);
        setCarInformation(cars);
    }

    private static String[] checkCarNameInput(String userInput) {
        String[] cars = userInput.split(",");
        checkCarDuplicate(cars);
        for (String car : cars) {
            checkEachCarName(car);
        }
        return cars;
    }

    private static void checkCarDuplicate(String[] cars) {
        boolean duplicate = checkDuplicateWithHashSet(cars);

        try {
            if (duplicate) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            System.err.println(ERROR_CAR_DUPLICATE);
            System.exit(0);
        }
    }

    private static boolean checkDuplicateWithHashSet(String[] cars) {
        Set<String> checkDuplicate = new HashSet<String>();
        for (String car : cars) {
            //중복된 원소가 있다
            if (checkDuplicate.contains(car)) {
                return true;
            }
            checkDuplicate.add(car);
        }
        return false;
    }

    private static void checkEachCarName(String car) {
        try {
            if ((car.length() == MIN_CAR_NAME_LENGTH) || (car.length() > MAX_CAR_NAME_LENGTH)) {
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
        int trialInput = checkTrialInput(userInput);
        checkNaturalNumber(trialInput);
        setNumberOfTrial(trialInput);
    }

    private static int checkTrialInput(String userInput) {
        int trialInput = 0;
        try {
            trialInput = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.err.println(ERROR_TRIAL_NUMBER);
            System.exit(0);
        }
        return trialInput;
    }

    private static void checkNaturalNumber(int trialInput) {
        try {
            if(trialInput <= 0) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            System.err.println(ERROR_TRIAL_NUMBER);
            System.exit(0);
        }
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
