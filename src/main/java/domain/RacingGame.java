package domain;

import java.util.ArrayList;

public class RacingGame {

    static void moveCar(ArrayList<Car> carArray) {
        for (int i = 0; i < carArray.size(); i++) {
            carArray.get(i).move();
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

        for (int i = 0; i < gameNumber; i++) {
            moveCar(carArray);
        }
    }
}
