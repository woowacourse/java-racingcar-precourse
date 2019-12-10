/*
 * class: TryingInput
 *
 * version: 3.0
 *
 * date: 2019.12.08
 *
 * 이 프로그램의 저작권은 정은석에게 있습니다.
 * Copyright 2019.12.08
 */

package domain;

import java.util.Scanner;

/**
 * 사용자가 시되횟수를 입력하는 기능을하는 class.
 *
 * @author joseph415
 * @version 3.0 2019.12.08
 */
public class TryingInput {
    public int tryCount;
    Scanner sc = new Scanner(System.in);

    /**
     * 사용자에게 시도횟수를 입력받는 매소드.
     *
     * @return 시도회수를 리턴.
     */
    public int tryInput() {
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            tryCount = sc.nextInt();

            /*예외처리*/
            if (tryCount < 1) {
                System.out.println("시도할 회수는 1회 이상 재입력!!");
                continue;
            }
            return tryCount;
        }
    }
}
