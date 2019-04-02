package domain;

import java.util.Scanner;

public class RaceAttemptReciever {
    private Scanner scanner = new Scanner(System.in);
    private int raceAttempt;

    private void RecieveRaceAttemptsFromUser() {
        try {
            tryToRecieveRaceAttemptsFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            tryToRecieveRaceAttemptsFromUser();
        }
    }

    private void tryToRecieveRaceAttemptsFromUser() throws IllegalArgumentException {
        System.out.println("시도할 횟수는 몇회인가요?");
        raceAttempt = scanner.nextInt();
        if (!isValidRaceAttempt()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidRaceAttempt() {
        System.out.println("이후 구현 예정");
        return true;
    }
}
