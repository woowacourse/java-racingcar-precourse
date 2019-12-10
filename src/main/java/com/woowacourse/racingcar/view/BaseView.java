package com.woowacourse.racingcar.view;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-12-09
 */
public abstract class BaseView {
    private static final String SYSTEM_MESSAGE_PREFIX = "# ";

    public static void showMessageWithNewLine(String message) {
        System.out.println(message);
    }

    public static void showSystemMessageWithNewLine(String message) {
        System.out.println(SYSTEM_MESSAGE_PREFIX + message);
    }
}
