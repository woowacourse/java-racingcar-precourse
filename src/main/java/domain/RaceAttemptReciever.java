package domain;

import java.util.Scanner;

public class RaceAttemptReciever {
    private static final int MINIMUM_RACE_ATTEMPT = 1;
    private Scanner scanner = new Scanner(System.in);
    private int raceAttempt;


    public void RecieveRaceAttemptFromUser() {
        try {
            tryToRecieveRaceAttemptFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            RecieveRaceAttemptFromUser();
        }
    }

    private void tryToRecieveRaceAttemptFromUser() throws IllegalArgumentException {
        System.out.println("시도할 횟수는 몇회인가요?");
        this.raceAttempt = scanner.nextInt();
        ThrowExceptionIfInvalidRaceAttempt();
    }

    private void ThrowExceptionIfInvalidRaceAttempt() throws IllegalArgumentException {
        if (isInValidRaceAttempt()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInValidRaceAttempt() {
        return this.raceAttempt < MINIMUM_RACE_ATTEMPT ? true : false;
    }
}
