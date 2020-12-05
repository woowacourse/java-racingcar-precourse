package racingcar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class GameInformation {
    private static int numberOfCarsInGame;
    private static int numberOfTrial;
    private static ArrayList<Car> carsInGame  = new ArrayList<Car>();
    private static String enterCarName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String enterNumberOfTrial = "시도할 회수는 몇회인가요?";
    private static String errorCarName = "[ERROR] 경주할 자동차 이름이 올바르게 입력되지 않았습니다.";
    //return String
    public static void getUserInput(Scanner scanner) {
        System.out.println(enterCarName);
        String userInput = scanner.nextLine();
        checkValidCarName(userInput);
        saveCarNameInformation(userInput);

        System.out.println(enterNumberOfTrial);
        userInput = scanner.nextLine();
        checkValidNumberOfTrial(userInput);
    }
    //예외처리
    private static void checkValidCarName(String userInput) {
        String[] cars = userInput.split(",");
        for(int i=0; i<cars.length; i++) {
            System.out.println(cars[i]);
            try {
                if(cars[i].equals("")) {
                    throw new UserInputException();
                }
            } catch (UserInputException e) {
                System.err.println(errorCarName);
                break;
            }
        }
    }

    private static void checkValidNumberOfTrial(String userInput) {
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


    private static void saveCarNameInformation(String userInput) {
        String[] cars = userInput.split(",");
        numberOfCarsInGame = cars.length;
        for(int i=0; i<numberOfCarsInGame; i++) {
            carsInGame.add(new Car(cars[i]));
        }
    }
}
