package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final String ERROR_EMPTY_NAME_MSG = "[ERROR] 공백 이름은 사용할 수 없습니다.";
    private static final String ERROR_ID_MAX_LENGTH_MSG = "[ERROR] 사용자의 아이디는 5글자 이하여야 합니다.";
    private static final String ERROR_ID_DUPLICATE_MSG = "[ERROR] 중복된 사용자 이름입니다.";
    private static final String ERROR_MAX_SIZE_OF_PEOPLE_MSG = "[ERROR] 인원숫자를 확인해주십시오. ( 5명 이하)";
    public static final String COLON_WRAPPED_BLANK = " : ";
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;

    private List<Car> cars;

    public Cars(String[] carNames){

        validateCarNamesSize(carNames);
        validateDuplicateCarNames(carNames);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            validateCarNameFormat(carName.trim());
            cars.add(new Car(carName));
        }

        this.cars = cars;
    }

    public void race() {
        for (Car car : cars) {
            car.race(RandomUtils.nextInt(MIN_VALUE, MAX_VALUE));
        }
    }

    public String printProgress() {
        StringBuffer progress = new StringBuffer();
        for (Car car : cars) {
            progress.append(car.getName()).append(COLON_WRAPPED_BLANK).append(revertPositionToDash(car.getPosition())).append(System.lineSeparator());
        }
        return progress.toString();
    }

    public List<String> findWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private String revertPositionToDash(int position) {
        StringBuffer dash = new StringBuffer();
        for (int i = 0; i < position; i++) {
            dash.append("-");
        }
        return dash.toString();
    }

    private void validateCarNameFormat(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME_MSG);
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ERROR_ID_MAX_LENGTH_MSG);
        }
    }

    private void validateDuplicateCarNames(String[] carNames) {
        Set<String> duplicateCheckSet = new HashSet<>(Arrays.asList(carNames));
        if (duplicateCheckSet.size() != carNames.length) {
            throw new IllegalArgumentException(ERROR_ID_DUPLICATE_MSG);
        }
    }

    private void validateCarNamesSize(String[] carNames) {
        if (carNames.length > 5) {
            throw new IllegalArgumentException(ERROR_MAX_SIZE_OF_PEOPLE_MSG);
        }
    }
}
