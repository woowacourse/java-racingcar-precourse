package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final static int REMOVE_LAST_MARK = 2;
    private List<Car> cars;

    public Cars(String[] names) {
        List<String> nameList = new ArrayList(Arrays.asList(names));
        this.cars = nameList.stream()
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        for (Car car : cars) {
            car.movePosition(RandomGenerator.randomGenerator());
        }
    }

    public String getCurrentResult() {
        StringBuilder currentResult = new StringBuilder();
        for (Car car : cars) {
            currentResult.append(car.getCurrentPosition());
            currentResult.append("\n");
        }
        return currentResult.toString();
    }

    public int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    public String getMaxResult(int maxPosition) {
        StringBuilder maxResult = new StringBuilder();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                maxResult.append(car.getName());
                maxResult.append(", ");
            }
        }
        return maxResult.toString().substring(0, maxResult.length() - REMOVE_LAST_MARK);
    }
}
