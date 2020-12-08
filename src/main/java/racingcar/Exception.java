package racingcar;

import java.util.HashSet;

public class Exception {
    private static final String BLANK_SPACE = "";
    private static final char NEGATIVE = '-';
	
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하여야 합니다.";
    private static final String CAR_NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 자동차 이름이 중복됩니다.";
    private static final String CAR_NAME_BLANK_ERROR_MESSAGE = "[ERROR] 자동차 이름이 공백입니다.";
    private static final String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수여야 합니다.";
    
    private String[] carNames;
    private int numberOfTry;
    
    public void checkCarNameException(String[] carNames) {
        this.carNames = carNames;
        checkCarNameLength();
        checkCarNameDuplicate();
        checkCarNameBlankSpace();
    }
    public void checkNumberOfTryException(int numberOfTry) {
        this.numberOfTry = numberOfTry;
        checkNegativeNumber();
    }
    
    public void checkCarNameLength() {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }
    public void checkCarNameDuplicate() {
        HashSet<String> name = new HashSet<String>();
        for (int i = 0; i < carNames.length; i++) {
            name.add(carNames[i]);
        }
        if (name.size() != carNames.length) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
    public void checkCarNameBlankSpace() {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].equals(BLANK_SPACE)) {
                throw new IllegalArgumentException(CAR_NAME_BLANK_ERROR_MESSAGE);
            }
        }
    }
    
    public static void checkIsDigit(String numberOfTry) {
        for (int i = 0; i < numberOfTry.length(); i++) {
            if (!Character.isDigit(numberOfTry.charAt(i)) && (numberOfTry.charAt(i) != NEGATIVE)) {
                throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
            }
        }
    }
    public void checkNegativeNumber() {
        if (numberOfTry < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}
