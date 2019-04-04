package domain;

import java.util.ArrayList;

public class CarRacingGame {
    private ArrayList<Car> cars = new ArrayList<>();
    private int moveCount = 0;

    public static void main(String[] args) {
        CarRacingGame racingGame = new CarRacingGame();
        racingGame.setConfiguration();
        racingGame.playGame();
    }

    private void setConfiguration() {
        Player user = new Player();
        this.cars = user.selectCar();
        this.moveCount = user.setMoveCount();
    }

    private void playGame() {
        for (int i = 0; i < this.moveCount; i++) {
            for (int j = 0; j < this.cars.size(); j++) {
                Car car = this.cars.get(j);
                car.decideMoveOrNot();
            }
        }
    }
}
