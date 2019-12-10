package domain;

import java.util.Scanner;

public class InputManager {

    public static String[] getCarNames() {
        String[] waiterList;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            Scanner scanner = new Scanner(System.in);
            String waiters = scanner.nextLine();
            waiterList = waiters.split(",");
        } while (!isLengthValid(waiterList));

        return waiterList;
    }

    private static boolean isLengthValid(String[] waiterList) {
        final int lengthLimit = 5;

        for (String waiter : waiterList) {
            if (waiter.length() > lengthLimit || waiter.length() == 0) {
                System.out.printf("이름은 없거나, %d 글자를 초과할 수 없습니다.", lengthLimit);
                return false;
            }
        }
        return true;
    }

    public static int getMoveCount() {
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

    private static int getNumber(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (!Character.isDigit(inputString.charAt(i))) {
                System.out.println("1 이상의 '숫자'를 입력해주세요.");
                return 0;
            }
        }
        return Integer.parseInt(inputString);
    }
}
