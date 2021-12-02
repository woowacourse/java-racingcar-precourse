package racingcar;

import java.util.ArrayList;
import java.util.HashSet;

public class Result {
    private final ArrayList<Car> cars;
    private int max = 0;

    public Result(ArrayList<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Car car : cars) {
            updateMax(car.getPosition());
            stringBuilder.append(car.getName()).append(" : ").append(makeDash(car.getPosition())).append("\n");
        }

        return stringBuilder.toString();
    }

    private void updateMax(int pos) {
        if(max < pos) {
            max = pos;
        }
    }

    public int getMax() {
        return max;
    }

    private String makeDash(int count) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < count; i++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }
}
