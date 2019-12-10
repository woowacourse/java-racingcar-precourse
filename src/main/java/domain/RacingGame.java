package domain;

import java.util.ArrayList;
import java.util.Collections;

public class RacingGame {
    private static ArrayList<Car> carArray = new ArrayList<Car>();

    private static void initGame(ArrayList<String> carNamesArray) {
        for (String name : carNamesArray) {
            carArray.add(new Car(name));
        }
    }

    private static void moveCar(ArrayList<Car> carArray) {
        for (int i = 0; i < carArray.size(); i++) {
            carArray.get(i).move();
            System.out.println(carArray.get(i).getName() + " : " + "-".repeat(carArray.get(i).getPosition()));
        }
        System.out.println("");
    }

    private static void playGame(int gameNumber) {
        System.out.println("\n실행결과");
        for (int i = 0; i < gameNumber; i++) {
            moveCar(carArray);
        }
    }

    private static ArrayList setWinner(ArrayList<Car> carArray) {
        ArrayList positionArray = new ArrayList();

        for (Car car : carArray) {
            positionArray.add(car.getPosition());
        }
        return positionArray;
    }

    private static void endGame(ArrayList<Car> carArray) {
        ArrayList positionArray = setWinner(carArray);
        int maxNum = (int)Collections.max(positionArray);
        ArrayList<String> winnerArray = new ArrayList<String>();

        for (Car car : carArray) {
            if (car.getPosition() == maxNum) {
                winnerArray.add(car.getName());
            }
        }

        System.out.println(String.join(", ", winnerArray) + " 차량이 최종 우승했습니다.");;
    }

    public static void main(String[] args) {
        initGame(InputProcessor.getCarName());
        playGame(InputProcessor.getGameNumber());
        endGame(carArray);
    }
}