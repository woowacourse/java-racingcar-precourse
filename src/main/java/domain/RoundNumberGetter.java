/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 클래스 이름 : RoundNumberGetter.java
 *
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * <p>
 * 날짜 : 2019.12.6 금요일
 */
public class RoundNumberGetter {
    /*
     * RoundNumberGetter 클래스는 플레이어로부터 시도할 회수를 입력받는 역할을 한다.
     */

    private static int roundNumber = 1;

    /**
     * 사용자에게 round 횟수를 입력받는 로직을 수행하는 메서드.
     */
    public static int controlRoundNumberGetting() {
        while (true) {
            if (askRoundNumber()) {
                break;
            }
        }

        return roundNumber;
    }

    /**
     * 사용자로부터 정수를 입력받는 문장 출력과 에러 컨트롤하는 메서드.
     * (Exception handling과 관련하여 메서드를 더 나눠보고 싶은데 어찌 해야할지 모르겠습니다. 추후 레퍼런스를 찾아보겠습니다.)
     */
    public static boolean askRoundNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            getInputNumber();
        } catch (InputMismatchException e) {
            System.out.println("1 이상의 정수만 입력해주세요.");
            return false;
        }
        return true;
    }

    /**
     * 사용자로부터 받은 입력을 정수로 저장하는 메서드. 오류시 exception을 throw.
     */
    public static void getInputNumber() {
        try {
            Scanner scan = new Scanner(System.in);
            roundNumber = scan.nextInt();
        } catch (InputMismatchException e) {
            throw e;
        }
    }

}
