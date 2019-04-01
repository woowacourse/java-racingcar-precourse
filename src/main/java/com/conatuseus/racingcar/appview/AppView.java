/*
 *  @(#)AppView.java       2.00    2019/04/01
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 */

package com.conatuseus.racingcar.appview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * AppView 클래스는 View를 담당하는 클래스
 * 이 클래스에는 사용자의 입출력과 관련된 메소드들이 있다.
 * 출력에 관한 메소드, 차 이름을 입력 메소드, 시도할 횟수 입력 메소드
 *
 * @author 사명기
 * @version 2.00    2019년 4월 1일
 */
public final class AppView {

    /* Scanner 변수 */
    private static final Scanner sc = new Scanner(System.in);

    /* String matches에 사용할 알파벳 REGEX 정의 */
    private static final String ALPHABET_REGEX = "^[a-zA-Z]*$";

    /* String matches에 사용할 숫자 REGEX 정의*/
    private static final String NUMBER_REGEX = "[0-9]*$";

    /* 가능한 이름의 최대 길이 저장 */
    private static final int VALID_NAME_LENGTH = 5;

    /* AppView 클래스 기본생성자*/
    private AppView() {
    }

    /* 매개변수 String을 print하는 메소드. 줄바꿈을 포함 */
    public static void outputLine(String aString) {
        System.out.println(aString);
    }

    /* 매개변수 String을 print하는 메소드. 줄바꿈 하지 않음 */
    public static void output(String aString) {
        System.out.print(aString);
    }

    /**
     * 자동차 이름을 입력 받는 메소드
     * String 배열에 입력을 받고, 올바른 입력이면 String 배열 반환
     *
     * @return 자동차 이름 배열 반환
     */
    public static String[] inputNameOfCar() {
        String[] scannedName;
        while (true) {
            outputLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            scannedName = sc.nextLine().split(",");                     // ','을 기준으로 나눔

            if (isNamesValid(scannedName)) {
                return scannedName;                                            // 옳은 입력이면 자동차 이름 배열 반환
            }
            outputLine("잘못 입력하였습니다.(5글자 이하 영문자, 중복되지 않는 이름을 입력하세요)");
        }
    }

    /**
     * 입력 받은 자동차 이름 배열이 올바른지 확인하는 메소드
     *
     * @param scannedName 입력 받은 자동차 이름 배열
     * @return 유효하다면 true, 올바르지 않다면 false 반환
     */
    public static boolean isNamesValid(String[] scannedName) {
        for (String name : scannedName) {
            if ((name.length() > VALID_NAME_LENGTH) || (!name.matches(ALPHABET_REGEX))) {
                return false;                   // 이름이 5보다 크거나, 알파벳 이외의 문자가 있으면
            }
        }
        return !isNameOverlap(scannedName);        // 중복된 이름이 있는지 없는지 반환
    }

    /**
     * 중복된 자동차 이름이 있는지 판단하는 메소드
     *
     * @param scannedName 자동차 이름 배열
     * @return 중복되는 이름이 있으면 true, 없으면 false
     */
    private static boolean isNameOverlap(String[] scannedName) {
        Set<String> hashSet = new HashSet<>();
        for (String name : scannedName) {
            if (hashSet.contains(name)) {
                return true;                // 해쉬셋에 이미 있는 이름이면 true 반환
            }
            hashSet.add(name);              // 해쉬셋에 없는 이름이면 해쉬셋에 추가
        }
        return false;           // 중복된 이름이 없으면
    }

    /**
     * 시도할 횟수 입력받는 메소드
     * @return 입력 받은 횟수 반환
     */
    public static int inputNumberOfTry() {
        outputLine("시도할 횟수는 몇회인가요?");
        String scannedNumberOfTry;

        while (true) {
            scannedNumberOfTry = sc.nextLine();

            if (scannedNumberOfTry.matches(NUMBER_REGEX)) {
                return Integer.parseInt(scannedNumberOfTry);        // 입력 받은 수가 올바르면 int로 반환
            }
            outputLine("잘못된 입력입니다. 정수만 입력하세요.");    // 올바른 수가 아니면
        }
    }
}
