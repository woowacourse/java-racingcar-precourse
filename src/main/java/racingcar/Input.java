package racingcar;

import java.util.HashSet;
import java.util.Scanner;

public class Input {
	private static final String SPLIT_DELIMITER = ",";
    private static final String BLANK_SPACE = "";
	
    private static final String GET_CAR_NAMES_MESSAGE = "경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GET_NUMBER_OF_TRY_MESSAGE = "시도할 회수는 몇회인가요?";
    
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하여야 합니다.";
    private static final String CAR_NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 자동차 이름이 중복됩니다.";
    private static final String CAR_NAME_BLANK_ERROR_MESSAGE = "[ERROR] 자동차 이름이 공백입니다.";
    private static final String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    
    private final Scanner scanner;
    
    private String[] carNames;
    private int numberOfTry;
    
    public Input(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public String[] getCarNames() {
        System.out.println(GET_CAR_NAMES_MESSAGE);
        String carNames = scanner.nextLine();
        this.carNames = carNames.split(SPLIT_DELIMITER);
        return this.carNames;
    }
    public int getNumberOfTry() {
        System.out.println(GET_NUMBER_OF_TRY_MESSAGE);
        String numberOfTry = scanner.next();
        checkIsDigit(numberOfTry);
        this.numberOfTry = Integer.parseInt(numberOfTry);
        return this.numberOfTry;
    }
    
    public void checkCarNameLength(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
            	throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }
    public void checkCarNameDuplicate(String[] carNames) {
        HashSet<String> name = new HashSet<String>();
    	for (int i = 0; i < carNames.length; i++) {
            name.add(carNames[i]);
        }
        if (name.size() != carNames.length) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
    public void checkCarNameBlankSpace(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].equals(BLANK_SPACE)) {
                throw new IllegalArgumentException(CAR_NAME_BLANK_ERROR_MESSAGE);
            }
        }
    }
    
    public void checkIsDigit(String numberOfTry) {
        for (int i = 0; i < numberOfTry.length(); i++) {
            if (!Character.isDigit(numberOfTry.charAt(i))) {
                throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
            }
    	}
    }
}
