package racingcar.view;

import racingcar.domain.Car;
import racingcar.exception.InputValidation;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private static ArrayList<Car> carsInGame = new ArrayList<Car>();
    private static int numberOfTrial;

    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_NUMBER_OF_TRIAL = "시도할 회수는 몇회인가요?";


    public static ArrayList<Car> getUserCarInput(Scanner scanner) {
        System.out.println(ENTER_CAR_NAME);
        String userInput = scanner.nextLine();
        String[] cars = InputValidation.checkCarNameInput(userInput);
        setCarInformation(cars);
        return carsInGame;
    }

    public static int getUserTrialInput(Scanner scanner) {
        System.out.println(ENTER_NUMBER_OF_TRIAL);
        String userInput = scanner.nextLine();
        int trialInput = InputValidation.checkTrialInput(userInput);
        setNumberOfTrial(trialInput);
        return numberOfTrial;
    }

    private static void setCarInformation(String cars[]) {
        for (int i = 0; i < cars.length; i++) {
            carsInGame.add(new Car(cars[i]));
        }
    }

    private static void setNumberOfTrial(int trialInput) {
        numberOfTrial = trialInput;
    }

    public static int getNumberOfTrial() {
        return numberOfTrial;
    }

    public static ArrayList getCarsInGame() {
        return carsInGame;
    }
}
