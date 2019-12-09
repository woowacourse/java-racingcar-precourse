/*
 *  @InputView.java
 *
 *  @Version: 0.2
 *
 *  @Date: 2019.12.09
 *
 *  @Author: pandahun
 */
package io;

import static domain.RacingGame.ZERO;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String DELIMITER  = ",";
    private static final String DOUBLE_COMMA = ",,";
    private static final String BLANK = " ";
    private static Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        String inputLine = SCANNER.nextLine();
        validatesName(inputLine);
        return Arrays.stream(inputLine.split(DELIMITER ))
                .collect(Collectors.toList());
    }

    private static void validatesName(String inputLine) {
        if (inputLine.endsWith(DELIMITER) || inputLine.contains(DOUBLE_COMMA) || inputLine.contains(BLANK))
            throw new IllegalArgumentException("name이 완벽하게 입력되지 않았습니다");
        if( Arrays.stream(inputLine.split(DELIMITER))
                .anyMatch(s -> s.length() > NAME_MAX_LENGTH)) {
            throw new IllegalArgumentException("이름이 5글자보다 깁니다.");
        }
    }

    public static Integer inputTryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        try {
            int tryCount = Integer.parseInt(SCANNER.nextLine());
            validatesNumber(tryCount);
            return tryCount;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }

    private static void validatesNumber(int tryCount) {
        if( tryCount <= ZERO) {
            throw new IllegalArgumentException("횟수는 1이상입니다.");
        }
    }
}
