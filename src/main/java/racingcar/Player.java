package racingcar;

import java.util.HashSet;
import java.util.Scanner;

public class Player {
    private static final String CAR_NAMES_DELIMITER = ",";
    private static final int SPLIT_LIMIT_INCLUDE_EMPTY_TOKENS = -1;
    private static final String CAR_NAMES_INPUT_MESSAGE =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR]";
    private static final String CAR_NAMES_LEGNTH_ERROR_MESSAGE =
            ERROR_MESSAGE_PREFIX + " 각 이름의 길이가 "
            + Car.NAME_MIN_LENGTH + " 이상 " + Car.NAME_MAX_LENGTH + " 이하가 되도록 입력해 주세요.";
    private static final String CAR_NAMES_DUPLICATED_ERROR_MESSAGE =
            ERROR_MESSAGE_PREFIX + " 각 이름이 중복되지 않게 입력해 주세요.";
    
    private final Scanner scanner;
    
    public Player(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public String[] carNamesInput() {
        String[] carNames;
        
        while (true) {
            try {
                System.out.println(CAR_NAMES_INPUT_MESSAGE);
                carNames = parseCarNames(this.scanner.nextLine());
                checkValidCarNames(carNames);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        
        return carNames;
    }
    
    private String[] parseCarNames(String rawInput) {
        String[] carNames = rawInput.split(CAR_NAMES_DELIMITER, SPLIT_LIMIT_INCLUDE_EMPTY_TOKENS);
        
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        
        return carNames;
    }
    
    private void checkValidCarNames(String[] carNames) {
        try {
            checkCarNamesValidLength(carNames);
            checkCarNamesNotDuplicated(carNames);
        } catch (IllegalArgumentException exception) {
            throw exception;
        }
    }
    
    private void checkCarNamesValidLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() < Car.NAME_MIN_LENGTH || carName.length() > Car.NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(CAR_NAMES_LEGNTH_ERROR_MESSAGE);
            }
        }
    }
    
    private void checkCarNamesNotDuplicated(String[] carNames) {
        HashSet<String> duplicatedCheckSet = new HashSet<String>();
        
        for (String carName : carNames) {
            if (duplicatedCheckSet.contains(carName)) {
                throw new IllegalArgumentException(CAR_NAMES_DUPLICATED_ERROR_MESSAGE);
            }
            duplicatedCheckSet.add(carName);
        }
    }
}
