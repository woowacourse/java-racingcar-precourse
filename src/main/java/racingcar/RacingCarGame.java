package racingcar;

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


    public void validateCarCount(List<String> cars) {
        if(cars.size()<2) {
            NOT_VALID_CAR_COUNT.throwError();
        }
    }

}
