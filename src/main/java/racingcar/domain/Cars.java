package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.utils.ValidationUtil;

public class Cars {
    public static final String DELIMITER = ",";
    public static final int START_INDEX = 0;
    public static final String NEW_LINE = System.lineSeparator();
    public static final String SPACE_STRING = " ";

    private List<Car> cars;

    private Cars(String carsName) {
        ValidationUtil.checkNames(carsName);
        makeCarsByName(carsName);
    }

    private void makeCarsByName(String carsName) {
        this.cars = Arrays.stream(carsName.trim().split(DELIMITER))
            .map(name -> {
                ValidationUtil.checkName(name);
                return new Car(name.trim());
            }).collect(Collectors.toList());
    }

    public static Cars createByNames(String carsName) {
        return new Cars(carsName);
    }

    public String getGameRecord() {
        return cars.stream().map(Car::getRecord).reduce((a, b) -> a + NEW_LINE + b).toString();
    }

    public void move(Engines engines) {
        IntStream.range(START_INDEX, cars.size()).forEach(index -> {
            if (engines.canOperate(index)) {
                cars.get(index).move();
            }
        });
    }

    public int getCarsCount() {
        return cars.size();
    }

    public String getWinner() {
        int maxPosition = getMaxPosition();
        StringBuilder stringBuilder = new StringBuilder();
        cars.stream().filter(car -> car.isSamePosition(maxPosition))
            .forEach(car -> stringBuilder.append(car + SPACE_STRING));
        return stringBuilder.toString().trim();
    }

    private int getMaxPosition() {
        return cars.stream().max(Car::compareTo).get().getPosition();
    }
}
