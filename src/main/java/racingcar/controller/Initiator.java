package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputViewer;
import racingcar.view.ErrorViewer;

import java.util.Scanner;

public class Initiator {
    private static final int LIMIT_PARTICIPANT_NAME = 5;
    private final Scanner scanner;

    public Initiator(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * 참가하는 참여자를 묻는 메서드
     * @return 참여자들이 객체로서 들어있는 Cars 객체
     */
    public Cars setParticipants() {
        InputViewer.carsInput();
        String primitiveArray = scanner.nextLine();
        checkVoid(primitiveArray);
        String[] participantsArray = primitiveArray.split(",");
        checkParticipantsLength(participantsArray);
        return new Cars(participantsArray);
    }

    private void checkParticipantsLength(String[] participantsArray) {
        for (String participant : participantsArray) {
            checkSingleParticipantLength(participant);
        }
    }

    private void checkSingleParticipantLength(String participant) {
        if (participant.length() > LIMIT_PARTICIPANT_NAME) {
            ErrorViewer.lengthInputError();
        }
    }

    /**
     * 게임의 총 횟수를 물어보는 메서드
     * @return 오류 체크가 끝난 게임의 총 진행 횟수
     */
    public int setTurns() {
        InputViewer.numberInput();
        String primitiveNumber = scanner.nextLine();
        checkVoid(primitiveNumber);
        return integerTranslator(primitiveNumber);
    }

    private int integerTranslator(String primitiveNumber) {
        try {
            return Integer.parseInt(primitiveNumber);
        } catch (Exception e) {
            ErrorViewer.numberInputError();
            return 0;
        }
    }

    private void checkVoid(String argument) {
        if (argument.equals("")) {
            ErrorViewer.voidInputError();
        }
    }
}
