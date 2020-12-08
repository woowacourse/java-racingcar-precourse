package racingcar;

import java.util.Scanner;

public class Input {
    private static final String SPLIT_DELIMITER = ",";
    
    private static final String GET_CAR_NAMES_MESSAGE = "경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GET_NUMBER_OF_TRY_MESSAGE = "시도할 회수는 몇회인가요?";
    
    private final Scanner scanner;
    
    public Input(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public String[] getCarNames() {
        System.out.println(GET_CAR_NAMES_MESSAGE);
        String carNames = scanner.nextLine();
        return carNames.split(SPLIT_DELIMITER);
    }
    public int getNumberOfTry() {
        System.out.println(GET_NUMBER_OF_TRY_MESSAGE);
        String numberOfTry = scanner.next();
        Exception.checkIsDigit(numberOfTry);
        return Integer.parseInt(numberOfTry);
    }
}
