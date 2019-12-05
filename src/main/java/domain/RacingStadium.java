package domain;

import java.util.Scanner;

public class RacingStadium {

    public RacingStadium() {
        String[] participants = recruitParticipants();
    }

    private String[] recruitParticipants() {
        String[] waiterList;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            Scanner scanner = new Scanner(System.in);
            String waiters = scanner.nextLine();
            waiterList = waiters.split(",");
        } while (!isValid(waiterList));

        return waiterList;
    }

    private boolean isValid(String[] waiterList) {
        for (String waiter : waiterList) {
            if (waiter.length() > 5 || waiter.length() == 0) {
                System.out.println("이름은 없거나, 5글자를 초과할 수 없습니다.");
                return false;
            }
        }
        return true;
    }
}
