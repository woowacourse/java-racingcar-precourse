package com.woowacourse.racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.woowacourse.racingcar.validator.InputValidator;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-12-09
 */
public class InputView extends BaseView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String TOTAL_LAPS_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String NAME_DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    // 기본 생성자가 만들어지는 것을 방지한다.
    private InputView() {
        throw new AssertionError();
    }

    // 자동차 이름의 중복 여부까지는 검증하지 않는다.
    public static List<String> getCarNames() {
        String input = "";
        while (!InputValidator.isValidNames(input)) {
            showSystemMessageWithNewLine(NAME_INPUT_MESSAGE);
            input = SCANNER.nextLine();
        }
        return Arrays.asList(input.split(NAME_DELIMITER));
    }

    public static int getTotalLaps() {
        try {
            showSystemMessageWithNewLine(TOTAL_LAPS_INPUT_MESSAGE);
            String input = SCANNER.nextLine();
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            return getTotalLaps();
        }
    }
}
