package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class InputCar implements AcceptableCar {
    private int numberTotalCars; // 참가자 수
    private String[] stringArrayCarNames; // 참가자 이름 목록
    private String stringInputCarNamesWithoutValidation; //  참가자 입력 자체

    public final int LENGTH_LIMIT_OF_INDIVIDUAL_CAR_NAME_INPUT = 5; // 참가자 이름 글자 수 제한
    public final String MESSAGE_ERROR_NOT_VALID_CAR_NAME = "[ERROR] 길이 " +
        LENGTH_LIMIT_OF_INDIVIDUAL_CAR_NAME_INPUT + "이하의 자동차 이름을 입력해주세요";

    public String[] input(Scanner scanner) {
        inputCarNames(scanner);
        validateCarNames();

        return stringArrayCarNames;
    }

    private void inputCarNames(Scanner scanner) {
        System.out.println(MESSAGE_INPUT_CARS);

        stringInputCarNamesWithoutValidation = scanner.nextLine();
        stringArrayCarNames = stringInputCarNamesWithoutValidation.split(DELIMITER);
        numberTotalCars = stringArrayCarNames.length;

        reInputTrimmedCarNames();
    }

    private void reInputTrimmedCarNames() {
        for (int i = 0; i < numberTotalCars; i++) {
            stringArrayCarNames[i] = stringArrayCarNames[i].trim();
        }
    }

    private void validateCarNames() {
        validateEmptyName();
        validateDuplicatedName();
        validateAbnormalDelimiter();

        for (String carName : stringArrayCarNames) {
            validateIndividualCarNameLength(carName);
        }
    }

    private void validateEmptyName() {
        if (numberTotalCars == LENGTH_EMPTY) {
            throw new IllegalArgumentException(MESSAGE_ERROR_EMPTY_CAR_NAME);
        }
    }

    private void validateDuplicatedName() {
        HashSet nameSet = new HashSet();

        nameSet.addAll(Arrays.asList(stringArrayCarNames));

        if(nameSet.size() != numberTotalCars) {
            throw new IllegalArgumentException(MESSAGE_ERROR_DUPLICATED_NAME);
        }
    }

    private void validateAbnormalDelimiter() {
        int expectedNumberTotalCars;
        int numberTotalDelimiters = 0;
        char[] charArrayInput = stringInputCarNamesWithoutValidation.toCharArray();

        for (char letter : charArrayInput) {
            numberTotalDelimiters += isChar(letter);
        }
        expectedNumberTotalCars = numberTotalDelimiters + 1; // 예상되는 참가자 수는 구분자 개수 + 1

        if(expectedNumberTotalCars != numberTotalCars) {
            throw new IllegalArgumentException(MESSAGE_ERROR_ABNORMAL_DELIMITER);
        }
    }

    private int isChar(char letter) {
        if (letter == ',') {
            return 1;
        }
        return 0;
    }

    private void validateIndividualCarNameLength(String carName) {
        int oneCarNameLength = carName.length();

        if (oneCarNameLength == LENGTH_EMPTY) {
            throw new IllegalArgumentException(MESSAGE_ERROR_FOUND_EMPTY_CAR_NAME);
        }

        if (oneCarNameLength > LENGTH_LIMIT_OF_INDIVIDUAL_CAR_NAME_INPUT) {
            throw new IllegalArgumentException(MESSAGE_ERROR_NOT_VALID_CAR_NAME);
        }
    }
}
