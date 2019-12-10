package com.woowacourse.racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-12-09
 */
public class RacingTrack {
    private static final String NOT_EXIST_CAR_EXCEPTION = "차가 한 대도 없습니다.";
    private static final String HAS_DUPLICATE_NAME_EXCEPTION = "중복된 이름을 가진 차가 있습니다.";
    private static final int ZERO = 0;
    private static final int NOT_EXIST_MAX_POSITION = -1;

    private final List<Car> cars;
    private final RandomPowerGenerator randomPowerGenerator;

    private RacingTrack(List<Car> cars, RandomPowerGenerator randomPowerGenerator) {
        validateCarCount(cars);
        validateDuplicate(cars);
        this.cars = Objects.requireNonNull(cars);
        this.randomPowerGenerator = Objects.requireNonNull(randomPowerGenerator);
    }

    private void validateCarCount(List<Car> cars) {
        if (cars.size() == ZERO) {
            throw new IllegalArgumentException(NOT_EXIST_CAR_EXCEPTION);
        }
    }

    private void validateDuplicate(List<Car> cars) {
        Set<Car> distinctCars = new HashSet<>(cars);
        if (cars.size() != distinctCars.size()) {
            throw new IllegalArgumentException(HAS_DUPLICATE_NAME_EXCEPTION);
        }
    }

    public static RacingTrack createRacingTrack(List<String> carNames, RandomPowerGenerator randomPowerGenerator) {
        return new RacingTrack(makeCars(carNames), randomPowerGenerator);
    }

    private static List<Car> makeCars(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        for (Car car: cars) {
            int power = randomPowerGenerator.getPower();
            car.forward(power);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Winner getRacingResult() {
        int maxPosition = getMaxPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
        return new Winner(winners);
    }

    private int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(NOT_EXIST_MAX_POSITION);
    }
}
