/*
 * UserInput.java    1.00 20190401
 *
 * Copyright (c) 2019 Hyeonyeong Baek.
 * All rights reserved.
 */
package domain;

import java.util.Scanner;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    public static String getString() {
        return sc.nextLine();
    }

    public static int getInteger() {
        int input;

        while (true) {  //정수값을 입력받을 때까지 반복
            try {
                input = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("숫자만 입력가능합니다.");
            }
        }
        return input;
    }
}
