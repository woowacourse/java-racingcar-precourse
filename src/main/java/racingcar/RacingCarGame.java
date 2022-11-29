package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.ErrorCode.NOT_VALID_CAR_COUNT;

public class RacingCarGame {


    public void validateCarCount(List<String> cars) {
        if(cars.size()<2) {
            NOT_VALID_CAR_COUNT.throwError();
        }
    }

}
