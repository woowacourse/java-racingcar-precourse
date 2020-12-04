package racingcar;

import java.util.Scanner;

public class GameInformation {
    private static int numberOfCarsInGame;
    private static int numberOfTrial;
    //return String
    public static void getUserInput(Scanner scanner) {
        String userInput = scanner.nextLine();
        checkValidInput(userInput);
        generateGameInformation(userInput);
    }

    public static int getNumberOfCarsInGame() {
        return numberOfCarsInGame;
    }

    public static int getNumberOfTrial() {
        return numberOfTrial;
    }

    //return array
    public static void getCarsArray() {
        
    }

    //예외처리
    private static void checkValidInput(String userInput) {

    }

    private static void generateGameInformation(String userInput) {

    }
}
