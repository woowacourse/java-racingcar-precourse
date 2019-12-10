package domain;

import java.util.ArrayList;
import java.util.Random;

public class RacingGame {

    static String returnCarName(String name) {
        Car newCar = new Car(name);
        return newCar.getName();
    }

    static void playGame(int gameNumber) {
        for (int i = 0; i < gameNumber; i++) {
            // moveCar();
        }
    }

    public static void main(String[] args) {
        ArrayList<String> carNamesArray;
        boolean isCarNameCorrect;
        int gameNumber;

        do {
            carNamesArray = GetCarNameInput.getCarNameInput();
            isCarNameCorrect = GetCarNameInput.checkCarNameInput(carNamesArray);
            GetCarNameInput.returnCarNameInput(carNamesArray);
        } while (!isCarNameCorrect);

        gameNumber = GetGameNumberInput.getGameNumberInput();

        // System.out.println("Cars: " + carNamesArray + ", Number of games: " + gameNumber);

        ArrayList<Car> carArray = new ArrayList<Car>();

        for (String name : carNamesArray) {
            carArray.add(new Car(name));
        }
        // System.out.println(carArray.get(0).getName());

        playGame(gameNumber);
    }
}
