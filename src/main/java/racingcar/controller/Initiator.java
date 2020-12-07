package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputViewer;

import java.util.Scanner;

public class Initiator {
    private static final int LIMIT_PARTICIPANT_NAME = 5;
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 참가하는 참여자를 묻는 메서드
     * @return 참여자들이 객체로서 들어있는 Cars 객체
     */
    public static Cars setParticipants() {
        InputViewer.carsInput();
        String[] participantsArray = scanner.nextLine().split(",");
        checkParticipantsLength(participantsArray);
        return new Cars(participantsArray);
    }
    private static void checkParticipantsLength(String[] participantsArray) {
        for (String parcipant : participantsArray) {
            checkParicipantLength(parcipant);
        }
    }

    private static void checkParicipantLength(String participant){
        if (participant.length() > LIMIT_PARTICIPANT_NAME) {
            InputViewer.lengthInputError();
        }
    }

    /**
     * 게임의 총 횟수를 물어보는 메서드
     * @return 오류 체크가 끝난 게임의 총 진행 횟수
     */
    public static int setTurns() {
        int turnNumber = 0;
        InputViewer.numberInput();
        try {
            turnNumber = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            InputViewer.numberInputError();
        }
        return turnNumber;
    }
}
