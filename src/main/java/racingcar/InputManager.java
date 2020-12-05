package racingcar;

import java.util.*;

public class InputManager {
    private static final String CAR_ERROR_STATEMENT = "[ERROR] 이름이 6자 이상 또는 중복 이름일 경우는 허용하지 않습니다";
    private static final String COUNT_ERROR_STATEMENT = "[ERROR] 숫자가 아닌 경우는 허용하지 않습니다";
    private static final int NAME_MAX_LENGTH = 5;
    private static final String SEPARATE = ",";
    private static final IllegalArgumentException CAR_INPUT_ERROR = new IllegalArgumentException(CAR_ERROR_STATEMENT);
    private static final IllegalArgumentException COUNT_INPUT_ERROR = new IllegalArgumentException(COUNT_ERROR_STATEMENT);

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

    public int inputTrialCount() throws IllegalArgumentException{
        String trialCount = scanner.next();
        for (int i=0; i<trialCount.length(); i++) {
            if (trialCount.charAt(i) - '0' > 9 || trialCount.charAt(i) - '0' < 0) {
                throw COUNT_INPUT_ERROR;
            }
        }
        return Integer.parseInt(trialCount);
    }
}
