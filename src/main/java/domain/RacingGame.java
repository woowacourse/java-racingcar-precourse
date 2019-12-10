package domain;

import java.util.ArrayList;
import java.util.Collections;

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
            System.out.println(carArray.get(i).getName() + " : " + "-".repeat(carArray.get(i).getPosition()));
        }
        System.out.println("");
    }

    static void playGame(int gameNumber) {
        System.out.println("\n실행결과");

        for (int i = 0; i < gameNumber; i++) {
            moveCar(carArray);
        }
    }

    static ArrayList setWinner(ArrayList<Car> carArray) {
        ArrayList positionArray = new ArrayList();

        for (Car car : carArray) {
            positionArray.add(car.getPosition());
        }
        return positionArray;
    }

    static void endGame(ArrayList<Car> carArray) {
        ArrayList positionArray = setWinner(carArray);
        int maxNum = (int) Collections.max(positionArray);
        ArrayList<String> winnerArray = new ArrayList<String>();

        for (Car car : carArray) {
            if (car.getPosition() == maxNum) {
                winnerArray.add(car.getName());
            }
        }

        System.out.println(String.join(", ", winnerArray) + "가 최종 우승했습니다.");;
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
        playGame(gameNumber);
        endGame(carArray);
    }
}
