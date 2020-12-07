package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Cars {
    private static final String COMMA = ",";

    private final ArrayList<Car> cars;

    private Cars(String carNames) {
        validateEmpty(carNames);
        validateDuplicate(carNames);
        this.cars = enrollCars(carNames);
    }

    public static Cars makeCars(String carNames) {
        return new Cars(carNames);
    }


    private void validateEmpty(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 입력해주세요.");
        }
    }

    private void validateDuplicate(String carNames) {
        ArrayList<String> listCarNames = new ArrayList<>(Arrays.asList(carNames.split(COMMA)));
        Set<String> setCarNames = new HashSet<>(Arrays.asList(carNames.split(COMMA)));
        if (listCarNames.size() != setCarNames.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름은 안됩니다.");
        }
    }

    private ArrayList<Car> enrollCars(String carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(COMMA)) {
            cars.add(Car.makeRandomForwardCar(carName));
        }
        return cars;
    }


}
