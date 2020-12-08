package racingcar;

import java.util.ArrayList;

public class RacingGamePlayers implements IRacingGamePlayers {
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
            if ((name.length() < 1) || (5 < name.length())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ArrayList<Car> getCars() {
        return null;
    }

    @Override
    public ArrayList<Car> getWinner() {
        return null;
    }
}