package domain;

import java.util.ArrayList;

public class CarRacingGame {
    private ArrayList<Car> cars = new ArrayList<>();
    private int moveCount = 0;
    private final String RESULT_HEADING = "실행 결과";
    private final String DELIMITER = " : ";

    public static void main(String[] args) {
        CarRacingGame racingGame = new CarRacingGame();
        racingGame.setConfiguration();
        racingGame.playGame();
        racingGame.decideWinners();
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
            this.displayProgress();
        }
    }

    private void displayProgress() {
        System.out.println(this.RESULT_HEADING);
        for (int i = 0; i < this.cars.size(); i++) {
            Car car = this.cars.get(i);
            String carName = car.getName();
            String visualizedPosition = car.visualizePosition();
            System.out.println(carName + this.DELIMITER + visualizedPosition);
        }
        System.out.println();
    }

    private ArrayList<Car> decideWinners() {
        int headPosition = 0;
        ArrayList<Car> winners = new ArrayList<>();
        for (int i = 0; i < this.cars.size(); i++) {
            Car car = this.cars.get(i);
            int carPosition = car.getPosition();
            if (carPosition > headPosition) {
                winners.clear();
                headPosition = carPosition;
                joinWinners(winners, car);
            }
            if (carPosition == headPosition) {
                joinWinners(winners, car);
            }
        }
        return winners;
    }

    private boolean isWinner(ArrayList<Car> winners, Car car) {
        for (int i = 0; i < winners.size(); i++) {
            if (winners.get(i) == car) {
                return true;
            }
        }
        return false;
    }

    private void joinWinners(ArrayList<Car> winners, Car car) {
        if (!isWinner(winners, car)) {
            winners.add(car);
        }
    }
}
