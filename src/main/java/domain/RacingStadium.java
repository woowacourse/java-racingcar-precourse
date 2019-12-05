package domain;

import java.util.Scanner;

public class RacingStadium {
    private final Car[] raceCars;
    private final int moveCount;

    public RacingStadium() {
        this.raceCars = getReady();
        this.moveCount = inputMoveCount();
    }

    private Car[] getReady() {
        String[] participants = recruitParticipants();
        Car[] startLine = new Car[participants.length];

        for (int i = 0; i < participants.length; i++) {
            startLine[i] = new Car(participants[i]);
        }
        return startLine;
    }

    private String[] recruitParticipants() {
        String[] waiterList;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            Scanner scanner = new Scanner(System.in);
            String waiters = scanner.nextLine();
            waiterList = waiters.split(",");
        } while (!isLengthValid(waiterList));

        return waiterList;
    }

    private boolean isLengthValid(String[] waiterList) {
        for (String waiter : waiterList) {
            if (waiter.length() > 5 || waiter.length() == 0) {
                System.out.println("이름은 없거나, 5글자를 초과할 수 없습니다.");
                return false;
            }
        }
        return true;
    }

    private int inputMoveCount() {
        String inputString;
        int moveCount;

        do {
            System.out.println("시도할 회수는 몇 회인가요?");
            Scanner scanner = new Scanner(System.in);
            inputString = scanner.nextLine();
            moveCount = getNumber(inputString);
        } while (moveCount == 0);

        return moveCount;
    }

    private int getNumber(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (!Character.isDigit(inputString.charAt(i))) {
                System.out.println("1 이상의 '숫자'를 입력해주세요.");
                return 0;
            }
        }
        return Integer.parseInt(inputString);
    }

    public void startRace() {
        for (int i = 0; i < moveCount; i++) {
            playRace();
        }
    }

    private void playRace() {
        for (Car raceCar : raceCars) {
            raceCar.tryToGoForward();
        }
    }
}
