package domain;

import java.util.ArrayList;

public class RacingGame {

    public static void main(String[] args) {

        ArrayList<String> carNamesArray;
        boolean isCarNameCorrect;

        do {
            carNamesArray = GetCarNameInput.getCarNameInput();
            isCarNameCorrect = GetCarNameInput.checkCarNameInput(carNamesArray);
            GetCarNameInput.returnCarNameInput(carNamesArray);
        } while (!isCarNameCorrect);

        System.out.println(carNamesArray);
    }
}
