package racingcar;

import java.util.*;

public class InputManager {
    private static final String CAR_ERROR_STATEMENT = "[ERROR] 이름이 6자 이상 또는 중복 이름일 경우는 허용하지 않습니다";
    private static final int NAME_MAX_LENGTH = 5;
    private static final String SEPARATE = ",";
    private static final IllegalArgumentException CAR_INPUT_ERROR = new IllegalArgumentException(CAR_ERROR_STATEMENT);

    private Scanner scanner;

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Car> generateCars() throws IllegalArgumentException {
        String carList = scanner.next();
        Set<Car> filteredCars = new LinkedHashSet<>();
        String[] preFilteredCars = carList.split(SEPARATE);
        for (String preFilteredCar : preFilteredCars) {
            if (preFilteredCar.length() > NAME_MAX_LENGTH) {
                throw CAR_INPUT_ERROR;
            }
            filteredCars.add(new Car(preFilteredCar));
        }
        if (preFilteredCars.length != filteredCars.size()) {
            throw CAR_INPUT_ERROR;
        }
        return new ArrayList<>(filteredCars);
    }
}
