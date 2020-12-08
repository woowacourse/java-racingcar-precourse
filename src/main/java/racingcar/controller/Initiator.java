package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputViewer;
import racingcar.view.ErrorViewer;

import java.util.Scanner;

public class Initiator {
    private static final String NO_SPACE = "";
    private static final String SPLIT_DELIMITER = ",";

    private final Scanner scanner;

    public Initiator(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * 참가하는 참여자를 묻는 메서드
     * @return 참여자들이 객체로서 들어있는 Cars 객체
     */
    public Cars askParticipants() {
        InputViewer.showCarsInput();
        String primitiveArray = scanner.nextLine();
        checkVoid(primitiveArray);
        String[] participantsArray = primitiveArray.split(SPLIT_DELIMITER);
        return new Cars(participantsArray);
    }

    /**
     * 게임의 총 횟수를 물어보는 메서드
     * @return 오류 체크가 끝난 게임의 총 진행 횟수
     */
    public int askTurns() {
        InputViewer.showNumberInput();
        String primitiveNumber = scanner.nextLine();
        checkVoid(primitiveNumber);
        int processedInteger = translateInteger(primitiveNumber);
        checkPositiveNumber(processedInteger);
        return processedInteger;
    }

    private int translateInteger(String primitiveNumber) {
        try {
            return Integer.parseInt(primitiveNumber);
        } catch (Exception e) {
            ErrorViewer.showIntegerInputError();
            return Integer.parseInt(primitiveNumber);
        }
    }

    private void checkPositiveNumber(int primitiveNumber) {
        if (primitiveNumber <=0) {
            ErrorViewer.showNotPositiveInputError();
        }
    }

    private void checkVoid(String argument) {
        if (argument.equals(NO_SPACE)) {
            ErrorViewer.showVoidInputError();
        }
    }
}
