package racingcar;

import java.util.HashMap;
import java.util.Scanner;

public class GameManager {
    public static int participantsTotal; // 참가자 수
    public static String[] stringArrayParticipants; // 참가자 이름 목록
    public static int numberTryToMove; // 이동 횟수 = 라운드 수
    private static HashMap<String, Car> participants = new HashMap<String, Car>(); // 참가자 이름: 참가자 Car
    private static final int LENGTH_LIMIT_OF_INDIVIDUAL_INPUT = 5;
    private static final int LENGTH_EMPTY = 0;
    private static final String DELIMITER = ",";
    private static final String MESSAGE_ERROR_NOT_VALID_CAR_NAME = "[ERROR] 길이 "+LENGTH_LIMIT_OF_INDIVIDUAL_INPUT+"이하의 자동차 이름을 입력해주세요";
    private static final String MESSAGE_ERROR_EMPTY_CAR_NAME = "[ERROR] 자동차 이름이 없습니다.";
    private static final String MESSAGE_ERROR_FOUND_EMPTY_CAR_NAME = "[ERROR] 자동차 이름이 없는 것이 있습니다.";
    private static final String MESSAGE_INPUT_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MESSAGE_INPUT_NUMBER_TRY_TO_MOVE = "시도할 횟수는 몇 회인가요?";
    private static final String MESSAGE_ERROR_NOT_VALID_TRY_NUMBER = "[ERROR] 시도 횟수는 1 이상의 자연수여야 합니다.";
    private static Board board;
    private static AwardGiver awardGiver;

    public GameManager() {
        board = new Board();
        awardGiver = new AwardGiver();
    }

    public void startGame(Scanner scanner) {
        inputParticipantsWithoutValidation(scanner);
        inputNumberTryToMove(scanner);
        registerCar(stringArrayParticipants);
        startAllRounds();
        board.printAccumulatedRoundsResult();
        awardGiver.printAwardReceiver(participants);
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
        validateTryNumberInput(stringInputTryNumber);
    }

    private void validateTryNumberInput(String stringInputTryNumber) {
        isNumber(stringInputTryNumber);
        isNaturalNumber(numberTryToMove);
    }

    private void isNaturalNumber(int numberTryToMove) {
        if (numberTryToMove < 1) {
            throw new IllegalArgumentException(MESSAGE_ERROR_NOT_VALID_TRY_NUMBER);
        }
    }

    private void isNumber(String stringInputTryNumber) {
        try {
            numberTryToMove = Integer.parseInt(stringInputTryNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MESSAGE_ERROR_NOT_VALID_TRY_NUMBER);
        }
    }

    private void inputParticipantsWithoutValidation(Scanner scanner) {
        System.out.println(MESSAGE_INPUT_CARS);
        stringArrayParticipants = scanner.nextLine().split(DELIMITER);
        participantsTotal = stringArrayParticipants.length;
        reInputTrimmedParticipants(stringArrayParticipants);
        validateCarInput(stringArrayParticipants);
    }

    private void reInputTrimmedParticipants(String[] stringArrayParticipants) {
        for (int i = 0; i < participantsTotal; i++) {
            stringArrayParticipants[i] = stringArrayParticipants[i].trim();
        }
    }

    private void validateCarInput(String[] stringArrayParticipants) {
        checkAllEmptyName();
        for (String participant : stringArrayParticipants) {
            validateIndividualCarInputLength(participant);
        }
    }

    private void checkAllEmptyName() {
        if (participantsTotal == LENGTH_EMPTY) {
            throw new IllegalArgumentException(MESSAGE_ERROR_EMPTY_CAR_NAME);
        }
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

    private void registerCar(String[] stringArrayParticipants) {
        for (int i = 0; i < participantsTotal; i++) {
            String carOwner = stringArrayParticipants[i];
            participants.put(carOwner, new Car(carOwner));
        }
    }


}
