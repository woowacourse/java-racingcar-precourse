package racingcar;

import java.util.HashMap;
import java.util.Scanner;

public class GameManager {
    public static int participantsTotal; // 참가자 수
    public static String[] stringArrayParticipants; // 참가자 이름 목록
    public static int numberTryToMove; // 이동 횟수 = 라운드 수
    private static HashMap<String, Car> participants = new HashMap<String, Car>(); // 참가자 이름: 참가자 Car
    private static final int LENGTH_LIMIT_OF_INDIVIDUAL_INPUT = 5;
    private static final String DELIMITER = ",";
    private static final String MESSAGE_ERROR_LIMIT_EXCESS = "[ERROR] 문자열 입력 한계를 초과했습니다.";
    private static final String MESSAGE_INPUT_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MESSAGE_INPUT_NUMBER_TRY_TO_MOVE = "시도할 횟수는 몇 회인가요?";
    private static final String MESSAGE_ERROR_NOT_VALID_TRY_NUMBER = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    private static Board board;

    public GameManager() {
        MovementArbiter movementArbiter = new MovementArbiter();
        board = new Board();
    }

    public void startGame(Scanner scanner) {
        inputParticipants(scanner);
        inputNumberTryToMove(scanner);
        registerCar(stringArrayParticipants);
        startAllRounds();
        board.printAccumulatedRoundsResult();
    }

    private void startAllRounds() {
        for (int roundNumber = 0; roundNumber < numberTryToMove; roundNumber++) {
            Round round = new Round();
            round.start(participants, roundNumber);
        }
    }

    private void inputNumberTryToMove(Scanner scanner) {
        System.out.println(MESSAGE_INPUT_NUMBER_TRY_TO_MOVE);
        String stringInputTryNumber = scanner.nextLine();
        numberTryToMove = validateTryNumberInput(stringInputTryNumber);
    }

    private int validateTryNumberInput(String stringInputTryNumber) {
        try {
            return Integer.parseInt(stringInputTryNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MESSAGE_ERROR_NOT_VALID_TRY_NUMBER);
        }
    }

    private void inputParticipants(Scanner scanner) {
        System.out.println(MESSAGE_INPUT_CARS);
        stringArrayParticipants = scanner.nextLine().split(DELIMITER);
        participantsTotal = stringArrayParticipants.length;
        validateCarInput(stringArrayParticipants);
    }

    private void validateCarInput(String[] stringArrayParticipants) {
        for (String participant : stringArrayParticipants) {
            validateIndividualCarInputLength(participant);
        }
    }

    private void validateIndividualCarInputLength(String participants) {
        if (participants.length() > LENGTH_LIMIT_OF_INDIVIDUAL_INPUT) {
            throw new IllegalArgumentException(MESSAGE_ERROR_LIMIT_EXCESS);
        }
    }

    private void registerCar(String[] stringArrayParticipants) {
        for (int i = 0; i < participantsTotal; i++) {
            String carOwner = stringArrayParticipants[i];
            participants.put(carOwner, new Car(carOwner));
        }
    }
}
