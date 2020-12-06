package racingcar;
import java.util.Scanner;

public class InputView {

    private static final String SEPERATOR = ",";
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIALS_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String INVALID_CAR_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.";
    private static final String INVALID_PLAYER_NUMBER_ERROR_MESSAGE = "[ERROR] 최소 한 개 이상의 이름을 입력해주세요.";
    private static final String INVALID_TRIAL_ERROR_MESSAGE = "[ERROR] 시도 횟수는 자연수여야 합니다.";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MIN_PLAYER_NUMBER = 1;
    private static final int MIN_TRIAL = 1;

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Car[] getCars() {
        String[] carNames = getCarList();
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    public String[] getCarList() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String[] carNames = getNames();
        if (!isValidCar(carNames)) {
            carNames = getCarList();
        }
        return carNames;
    }

    public int getTrials() {
        System.out.println(INPUT_TRIALS_MESSAGE);
        int trials =  Integer.parseInt(getInput());
        if (!isValidTrials(trials)) {
            trials = getTrials();
        }
        return trials;
    }

    private String getInput() {
        return scanner.nextLine();
    }

    private String[] getNames() {
        return getInput().split(SEPERATOR);
    }

    private boolean isValidCar(String[] carNames) {
        return isValidNameLength(carNames) && isValidPlayerNumber(carNames);
    }

    private boolean isValidNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() < MIN_NAME_LENGTH || carName.length() > MAX_NAME_LENGTH) {
                System.out.println(INVALID_CAR_NAME_ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private boolean isValidPlayerNumber(String[] carNames) {
        if (carNames.length < MIN_PLAYER_NUMBER) {
            System.out.println(INVALID_PLAYER_NUMBER_ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isValidTrials(int trials) {
        if (trials < MIN_TRIAL) {
            System.out.println(INVALID_TRIAL_ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
