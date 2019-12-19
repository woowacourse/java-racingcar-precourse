package domain;

import generater.RandomGenerater;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int EMPTY = 0;

    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        checkCarNameIsEmpty();
        this.racingCars = racingCars;
    }

    private void checkCarNameIsEmpty() {
        if (racingCars.size() == EMPTY) {
            throw new IllegalArgumentException("자동차 이름을 채워주세요!");
        }
    }

    public static RacingCars initRacingCars(String[] carNames) {
        List<Car> Cars = new ArrayList<>();
        for (String carName : carNames) {
            Cars.add(Car.generateCar(carName));
        }
        return new RacingCars(Cars);
    }

    public void move() {
        this.racingCars.forEach(car -> {
            car.move(RandomGenerater.generateRandom());
        });
    }

    public List<Car> decideWinners() {
        int maxPosition = getMaxPosition(racingCars);
        if (maxPosition == EMPTY) {
            return Collections.emptyList();
        }
        return racingCars.stream()
                .filter(car -> car.isMatchPosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> racingCars) {
        // TODO : 최고값 구하기
        Car winner = racingCars.stream()
                .max(Comparator.comparingInt(Car::getPosition)).get();
        return winner.getPosition();
    }

    public List<Car> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
