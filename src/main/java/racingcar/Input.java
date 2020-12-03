package racingcar;

import java.util.Scanner;

public class Input {
	private static final String SPLIT_DELIMITER = ",";
	
    private static final String GET_CAR_NAMES_MESSAGE = "경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GET_NUMBER_OF_TRY_MESSAGE = "시도할 회수는 몇회인가요?";
    
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하여야 합니다.";
    private static final String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    
    private final Scanner scanner;
    
    private String carNames;
    private int numberOfTry;
    
    public Input(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public String[] getCarName() {
        System.out.println(GET_CAR_NAMES_MESSAGE);
        carNames = scanner.next();
        String[] carName = carNames.split(SPLIT_DELIMITER);
        return carName;
    }
    public int getNumberOfTry() {
        System.out.println(GET_NUMBER_OF_TRY_MESSAGE);
        numberOfTry = scanner.nextInt();
        checkIsDigit(numberOfTry);
        return numberOfTry;
    }
    
    public void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
        	throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }
    public void checkIsDigit(int numberOfTry) {
        if (!Character.isDigit(numberOfTry)) {
        	throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }
}
