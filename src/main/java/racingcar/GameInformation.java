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

    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_NUMBER_OF_TRIAL = "시도할 회수는 몇회인가요?";

    //return String
    public static void getUserInput(Scanner scanner) {
        getCarInput(scanner);
        getTrialInput(scanner);
    }

    private static void getCarInput(Scanner scanner) {
        System.out.println(ENTER_CAR_NAME);
        String userInput = scanner.nextLine();
        String[] cars = CarInputValidation.checkCarNameInput(userInput);
        setCarInformation(cars);
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
        int trialInput = TrialInputValidation.checkTrialInput(userInput);
        setNumberOfTrial(trialInput);
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
