package racingcar;

import java.util.ArrayList;

public class RacingGamePlayers implements IRacingGamePlayers {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    private ArrayList<Car> cars;

    @Override
    public boolean trySetCars(String input) {
        if (!isValidNamesInput(input)) {
            return false;
        }
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : input.split(",")) {
            cars.add(new Car(name));
        }
        this.cars = cars;
        return true;
    }

    private boolean isValidNamesInput(String input) {
        if (input.charAt(input.length() - 1) == ',') {
            return false;
        }
        for (String name : input.split(",")) {
            if ((name.length() < MIN_NAME_LENGTH) || (MAX_NAME_LENGTH < name.length())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ArrayList<Car> getCars() {
        return cars;
    }

    @Override
    public ArrayList<Car> getWinner() {
        int highestScore = getHighestScore();
        ArrayList<Car> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == highestScore) {
                winner.add(car);
            }
        }
        return winner;
    }

    private int getHighestScore() {
        int score = 0;
        for (Car car : cars) {
            score = Math.max(score, car.getPosition());
        }
        return score;
    }
}