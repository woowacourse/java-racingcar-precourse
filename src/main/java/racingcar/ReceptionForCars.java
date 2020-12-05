package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ReceptionForCars {
    private int participantsTotal; // 참가자 수
    private String[] stringArrayParticipants; // 참가자 이름 목록
    private String stringInputWithoutValidation; //  참가자 입력 자체

    private static final int LENGTH_EMPTY = 0;
    private static final String DELIMITER = ",";
    private static final String MESSAGE_INPUT_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MESSAGE_ERROR_ABNORMAL_DELIMITER = "[ERROR] 잘못된 구분자(" + DELIMITER + ") 사용이 있습니다.";
    private static final String MESSAGE_ERROR_DUPLICATED_NAME = "[ERROR] 중복된 자동차 이름이 있습니다.";
    private static final String MESSAGE_ERROR_EMPTY_CAR_NAME = "[ERROR] 자동차 이름이 없습니다.";
    private static final String MESSAGE_ERROR_FOUND_EMPTY_CAR_NAME = "[ERROR] 자동차 이름이 없는 것이 있습니다.";
    private final int LENGTH_LIMIT_OF_INDIVIDUAL_INPUT = 5; // 참가자 이름 글자 수 제한
    private final String MESSAGE_ERROR_NOT_VALID_CAR_NAME = "[ERROR] 길이 " + LENGTH_LIMIT_OF_INDIVIDUAL_INPUT + "이하의 자동차 이름을 입력해주세요";

    public String[] input(Scanner scanner) {
        inputParticipants(scanner);
        validateCarInput();

        return stringArrayParticipants;
    }

    private void inputParticipants(Scanner scanner) {
        System.out.println(MESSAGE_INPUT_CARS);

        stringInputWithoutValidation = scanner.nextLine();
        stringArrayParticipants = stringInputWithoutValidation.split(DELIMITER);
        participantsTotal = stringArrayParticipants.length;

        reInputTrimmedParticipants();
    }

    private void reInputTrimmedParticipants() {
        for (int i = 0; i < participantsTotal; i++) {
            stringArrayParticipants[i] = stringArrayParticipants[i].trim();
        }
    }

    private void validateCarInput() {
        validateAllEmptyName();
        validateDuplicatedName();
        validateAbnormalDelimiter();

        for (String participant : stringArrayParticipants) {
            validateIndividualCarInputLength(participant);
        }
    }

    private void validateAllEmptyName() {
        if (participantsTotal == LENGTH_EMPTY) {
            throw new IllegalArgumentException(MESSAGE_ERROR_EMPTY_CAR_NAME);
        }
    }

    private void validateDuplicatedName() {
        HashSet nameSet = new HashSet();

        nameSet.addAll(Arrays.asList(stringArrayParticipants));

        if(nameSet.size() != participantsTotal) {
            throw new IllegalArgumentException(MESSAGE_ERROR_DUPLICATED_NAME);
        }
    }

    private void validateAbnormalDelimiter() {
        int expectedParticipantsTotal;
        int countDelimiter = 0;
        char[] charArrayInput = stringInputWithoutValidation.toCharArray();

        for (char letter : charArrayInput) {
            countDelimiter += isChar(letter);
        }
        expectedParticipantsTotal = countDelimiter + 1; // 예상되는 참가자 수는 구분자 개수 + 1

        if(expectedParticipantsTotal != participantsTotal) {
            throw new IllegalArgumentException(MESSAGE_ERROR_ABNORMAL_DELIMITER);
        }
    }

    private int isChar(char letter) {
        if (letter == ',') {
            return 1;
        }
        return 0;
    }

    private void validateIndividualCarInputLength(String participant) {
        int oneCarNameLength = participant.length();

        if (oneCarNameLength == LENGTH_EMPTY) {
            throw new IllegalArgumentException(MESSAGE_ERROR_FOUND_EMPTY_CAR_NAME);
        }

        if (oneCarNameLength > LENGTH_LIMIT_OF_INDIVIDUAL_INPUT) {
            throw new IllegalArgumentException(MESSAGE_ERROR_NOT_VALID_CAR_NAME);
        }
    }
}
