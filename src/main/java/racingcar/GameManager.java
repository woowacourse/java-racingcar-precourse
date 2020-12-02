package racingcar;

import java.util.HashMap;
import java.util.Scanner;

public class GameManager {
    private static final int LENGTH_LIMIT_OF_INDIVIDUAL_INPUT = 5;
    private static final String DELIMITER = ",";
    private static final String MESSAGE_LIMIT_EXCESS = "[ERROR] 문자열 입력 한계를 초과했습니다.";
    private static int participantsTotal; // 참가자 총원
    private static String[] stringArrayParticipants;
    private static HashMap<String, Car> participants = new HashMap<String, Car>(); // 참가자 이름: 참가자 Car

    public GameManager() {

    }

    public void gameStart(Scanner scanner) {
        inputParticipants(scanner);
        registerCar(stringArrayParticipants);
    }

    private void inputParticipants(Scanner scanner) {
        stringArrayParticipants = scanner.nextLine().split(DELIMITER);
        participantsTotal = stringArrayParticipants.length;
        validateInput(stringArrayParticipants);
    }

    private void validateInput(String[] stringArrayParticipants) {
        for (String participants : stringArrayParticipants) {
            validateIndividualInputLength(participants);
        }
    }

    private void validateIndividualInputLength(String participants) {
        if (participants.length() > LENGTH_LIMIT_OF_INDIVIDUAL_INPUT) {
            throw new IllegalArgumentException(MESSAGE_LIMIT_EXCESS);
        }
    }

    private void registerCar(String[] stringArrayParticipants) {
        for (int i = 0; i < participantsTotal; i++) {
            String carOwner = stringArrayParticipants[i];
            participants.put(carOwner, new Car(carOwner));
        }
        printMap(participants);
    }
    private void printMap(HashMap<String, Car> hashMap) {
        System.out.println(hashMap);
    }
}
