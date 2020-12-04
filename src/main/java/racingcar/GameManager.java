package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GameManager {
    private int numberTryToMove; // 이동 횟수 = 라운드 수
    private int participantsTotal; // 참가자 수
    private String[] stringArrayParticipants; // 참가자 이름 목록
    private HashMap<String, Car> participants = new HashMap<String, Car>(); // 참가자 이름: 참가 Car
    private Board board; // 전광판
    private AwardGiver awardGiver; // 시상자
    private Reception reception;

    private static final int LENGTH_EMPTY = 0;
    private static final int MINIMUM_NATURAL_NUMBER = 1;
    private static final String DELIMITER = ",";
    private static final String MESSAGE_ERROR_EMPTY_CAR_NAME = "[ERROR] 자동차 이름이 없습니다.";
    private static final String MESSAGE_ERROR_FOUND_EMPTY_CAR_NAME = "[ERROR] 자동차 이름이 없는 것이 있습니다.";
    private static final String MESSAGE_INPUT_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MESSAGE_INPUT_NUMBER_TRY_TO_MOVE = "시도할 횟수는 몇 회인가요?";
    private static final String MESSAGE_ERROR_NOT_VALID_TRY_NUMBER = "[ERROR] 시도 횟수는 1 이상의 자연수여야 합니다.";
    private final int LENGTH_LIMIT_OF_INDIVIDUAL_INPUT = 5; // 참가자 이름 글자 수 제한
    private final String MESSAGE_ERROR_NOT_VALID_CAR_NAME = "[ERROR] 길이 " + LENGTH_LIMIT_OF_INDIVIDUAL_INPUT + "이하의 자동차 이름을 입력해주세요";



    public GameManager() {
        board = new Board();
        awardGiver = new AwardGiver();
        reception = new Reception();
    }

    public void startGame(Scanner scanner) {
        inputParticipantsWithoutValidation(scanner);
        inputNumberTryToMove(scanner);

        registerCar(stringArrayParticipants);
        startAllRounds();

        ArrayList<HashMap<String, Integer>> allRoundsResults = Round.getRoundsInformation();
        board.printAccumulatedRoundsResult(allRoundsResults, numberTryToMove);
        awardGiver.printAwardReceiver(participants, allRoundsResults, numberTryToMove);
    }

    private void inputParticipantsWithoutValidation(Scanner scanner) {
        System.out.println(MESSAGE_INPUT_CARS);

        String stringInput = scanner.nextLine();
        stringArrayParticipants = stringInput.split(DELIMITER);

        participantsTotal = stringArrayParticipants.length;

        reInputTrimmedParticipants();
        validateCarInput();
    }

    private void reInputTrimmedParticipants() {
        for (int i = 0; i < participantsTotal; i++) {
            stringArrayParticipants[i] = stringArrayParticipants[i].trim();
        }
    }

    private void validateCarInput() {
        checkAllEmptyName();
        checkDuplicatedName();
        checkAbnormalComma();

        for (String participant : stringArrayParticipants) {
            validateIndividualCarInputLength(participant);
        }
    }

    private void checkAllEmptyName() {
        if (participantsTotal == LENGTH_EMPTY) {
            throw new IllegalArgumentException(MESSAGE_ERROR_EMPTY_CAR_NAME);
        }
    }

    private void checkDuplicatedName() {

    }

    private void checkAbnormalComma() {

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

    private void inputNumberTryToMove(Scanner scanner) {
        System.out.println(MESSAGE_INPUT_NUMBER_TRY_TO_MOVE);

        String stringInputTryNumber = scanner.nextLine();

        validateNumberInput(stringInputTryNumber);
    }

    private void validateNumberInput(String stringInputTryNumber) {
        isNumber(stringInputTryNumber);
        isNaturalNumber(numberTryToMove);
    }

    private void isNumber(String stringInputTryNumber) {
        try {
            numberTryToMove = Integer.parseInt(stringInputTryNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MESSAGE_ERROR_NOT_VALID_TRY_NUMBER);
        }
    }

    private void isNaturalNumber(int numberTryToMove) {
        if (numberTryToMove < MINIMUM_NATURAL_NUMBER) {
            throw new IllegalArgumentException(MESSAGE_ERROR_NOT_VALID_TRY_NUMBER);
        }
    }

    private void registerCar(String[] stringArrayParticipants) {
        for (int i = 0; i < participantsTotal; i++) {
            String carOwner = stringArrayParticipants[i];
            participants.put(carOwner, new Car(carOwner));
        }
    }

    private void startAllRounds() {
        for (int roundNumber = 0; roundNumber < numberTryToMove; roundNumber++) {
            Round round = new Round();
            round.start(participants, round, roundNumber);
        }
    }
}
