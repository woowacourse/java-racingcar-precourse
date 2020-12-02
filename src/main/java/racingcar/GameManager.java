package racingcar;

import java.util.HashMap;
import java.util.Scanner;

public class GameManager {
    private static final String DELIMITER = ",";
    private static int participantsTotal; // 참가자 총원
    private static String[] stringArrayParticipants;
    private static HashMap<String, Car> participants = new HashMap<String, Car>(); // 참가자 이름: 참가자 Car

    public GameManager() {

    }

    public void gameStart(Scanner scanner) {
        inputParticipants(scanner);
    }

    private void inputParticipants(Scanner scanner) {
        stringArrayParticipants = scanner.nextLine().split(DELIMITER);
        participantsTotal = stringArrayParticipants.length;
        registerCar(stringArrayParticipants);
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
