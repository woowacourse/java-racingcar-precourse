package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.ErrorCode.NOT_VALID_CAR_COUNT;

public class RacingCarGame {
    private List<Car> cars;

    public RacingCarGame(List<String> cars) {
        validateCarCount(cars);
        setCars(cars);
    }

    //차 객체들로 변환
    public void setCars(List<String> carNames) {
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void raceCars() {
        for(Car car : cars) {
            car.move();
        }
    }

    public List<String> getMovingResult() {
        List<String> movingResult = new ArrayList<>();
        for(Car car : cars) {
            movingResult.add(car.getPosition());
        }
        return movingResult;
    }

    public List<String> getRacingResult() {
        int longestPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition().length()== getMaxPosition())
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return cars.stream()
                .map(car -> car.getPosition().length())
                .max(Integer::compareTo)
                .get().intValue();
    }




    public void validateCarCount(List<String> cars) {
        if(cars.size()<2) {
            NOT_VALID_CAR_COUNT.throwError();
        }
    }

}
