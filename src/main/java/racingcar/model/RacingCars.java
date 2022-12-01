package racingcar.model;

import racingcar.RandomNumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCars {

    private static final String CAR_POSITION_KEY = "position";
    private static final String CAR_NAME_KEY = "name";

    private static final int MIN_FORWARD_NUMBER = 4;

    private int maxPosition = Integer.MIN_VALUE;
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public void forwardTry() {
        for (Car racingCar : racingCars) {
            int randomNumber = RandomNumberGenerator.generate();
            if (randomNumber >= MIN_FORWARD_NUMBER) {
                racingCar.forward();
            }
        }
    }

    public List<Car> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    public List<String> decideWinners() {
        setMaxPosition();
        return racingCars.stream()
                .filter(racingCar -> {
                    int position = racingCar.getCarInfos().get(CAR_POSITION_KEY).length();
                    return position == maxPosition;
                })
                .map(racingCar -> racingCar.getCarInfos().get(CAR_NAME_KEY))
                .collect(Collectors.toList());
    }

    private void setMaxPosition() {
        for (Car racingCar : racingCars) {
            Map<String, String> carInfos = racingCar.getCarInfos();
            int position = carInfos.get(CAR_POSITION_KEY).length();
            if (maxPosition < position) {
                maxPosition = position;
            }
        }
    }
}
