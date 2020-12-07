package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Cars {

    private static final String WHITE_SPACE = " ";
    private static final String NO_STRING = "";
    private static final String COMMA = ",";
    private static final char CHAR_COMMA = ',';
    private static final int EMPTY = 0;
    private static final int INIT_ZERO = 0;

    private final ArrayList<Car> cars;

    private Cars(String carNames) {
        validateEmpty(carNames);
        validateCommaCount(carNames);
        validateDuplicate(carNames);
        this.cars = enrollCars(carNames);
    }

    public static Cars newCars(String carNames) {
        return new Cars(carNames);
    }


    private void validateEmpty(String carNames) {
        if (carNames.replaceAll(WHITE_SPACE, NO_STRING).length() == EMPTY) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }


    private void validateCommaCount(String carNames) {
        if (carNames.charAt(carNames.length() - 1) == CHAR_COMMA) {
            throw new IllegalArgumentException("자동차 이름이 충분히 입력되지 않았습니다.");
        }
    }

    private void validateDuplicate(String carNames) {
        ArrayList<String> listCarNames = new ArrayList<>(Arrays.asList(carNames.split(COMMA)));
        Set<String> setCarNames = new HashSet<>(Arrays.asList(carNames.split(COMMA)));
        if (listCarNames.size() != setCarNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 안됩니다.");
        }
    }

    private ArrayList<Car> enrollCars(String carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(COMMA)) {
            cars.add(Car.newCar(carName));
        }
        return cars;
    }

    public StringBuilder continueRacing() {
        StringBuilder positions = new StringBuilder();
        for (Car car : cars) {
            car.tryForward();
            car.currentPosition(positions);
        }
        return positions;
    }

    public ArrayList<String> awardWinners() {
        ArrayList<String> winners = new ArrayList<>();
        int max_distance = INIT_ZERO;
        for (Car car : cars) {
            max_distance = car.award(winners, max_distance);
        }
        return winners;
    }
}
