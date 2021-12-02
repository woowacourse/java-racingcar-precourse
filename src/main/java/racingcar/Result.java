package racingcar;

import java.util.ArrayList;

public class Result {
    private final ArrayList<Car> cars;

    public Result(ArrayList<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Car car : cars) {
            stringBuilder.append(car.getName()).append(" : ").append(makeDash(car.getPosition())).append("\n");
        }

        return stringBuilder.toString();
    }

    private String makeDash(int count) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < count; i++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }
}
