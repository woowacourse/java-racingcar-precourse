package domain;

import java.util.ArrayList;

public class RacingGame {

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

        System.out.println("Cars: " + carNamesArray + ", Number of games: " + gameNumber);
    }
}
