package domain;

import java.util.ArrayList;

public class RacingGame {

    static ArrayList<Car> carArray = new ArrayList<Car>();

    static ArrayList<Car> createCar(ArrayList<String> carNamesArray) {
        for (String name : carNamesArray) {
            carArray.add(new Car(name));
        }
        return carArray;
    }

    static void moveCar(ArrayList<Car> carArray) {
        for (int i = 0; i < carArray.size(); i++) {
            carArray.get(i).move();
            System.out.println(carArray.get(i).getName() + " : " + carArray.get(i).getPosition()); //"-".repeat(carArray.get(i).getPosition()));
        }
        System.out.println("");
    }

    static void playGame(int gameNumber) {
        for (int i = 0; i < gameNumber; i++) {
            moveCar(carArray);
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

        createCar(carNamesArray);
        System.out.println("\n실행결과");
        playGame(gameNumber);
    }
}
