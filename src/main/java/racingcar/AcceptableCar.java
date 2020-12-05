package racingcar;

import java.util.Scanner;

interface AcceptableCar {
    int LENGTH_EMPTY = 0;
    String DELIMITER = ",";
    String MESSAGE_INPUT_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    String MESSAGE_ERROR_ABNORMAL_DELIMITER = "[ERROR] 잘못된 구분자(" + DELIMITER + ") 사용이 있습니다.";
    String MESSAGE_ERROR_DUPLICATED_NAME = "[ERROR] 중복된 자동차 이름이 있습니다.";
    String MESSAGE_ERROR_EMPTY_CAR_NAME = "[ERROR] 자동차 이름이 없습니다.";
    String MESSAGE_ERROR_FOUND_EMPTY_CAR_NAME = "[ERROR] 자동차 이름이 없는 것이 있습니다.";

    String[] input(Scanner scanner);
}
