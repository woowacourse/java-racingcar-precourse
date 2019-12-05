/**
 * User.java
 * 아직 리팩토링 중...
 * 우아한테크코스 프리코스 2주차.
 * Original code https://github.com/hotheadfactory/java-racingcar-precourse
 * Version: v0.0.1, 2019.12.05 (c) 정회형
 */
package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
    private static final int MAX_NAME_DIGIT = 5;

    public String[] getCarNames() {
        while (true) {
            String[] carArray = getCarArray();
            if (carArray != null) {
                return carArray;
            }
        }
    }

    private String[] getCarArray() {
        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carArray = scan.nextLine().split(",");
        if (verifyCarName(carArray)) {
            return carArray;
        }
        System.out.println("다시 입력해 주세요.");
        return null;
    }

    private boolean verifyCarName(String[] carArray) {
        for (String oneName : carArray) {
            if (oneName.length() > MAX_NAME_DIGIT || oneName.length() == 0) {
                return false;
            }
        }
        return true;
    }

    public int getTurnNumber() {
        while (true) {
            System.out.println("시도할 횟수는 몇 회인가요?");
            try {
                return getPositiveInt();
            } catch (InputMismatchException e) {
                System.out.println("다시 입력해 주세요.");
            }
        }
    }

    private int getPositiveInt() {
        Scanner scan = new Scanner(System.in);
        int turnNumber = scan.nextInt();
        if (turnNumber <= 0) {
            throw new InputMismatchException();
        }
        return turnNumber;
    }
}
