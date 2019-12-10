package com.woowacourse.racingcar.view;

import java.util.List;

import com.woowacourse.racingcar.domain.Car;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-12-09
 */
public class OutputView extends BaseView {
    private static final String NAME_DELIMITER = ", ";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";

    // 기본 생성자가 만들어지는 것을 방지한다.
    private OutputView() {
        throw new AssertionError();
    }

    public static void showRunResultMessage() {
        showSystemMessageWithNewLine(RESULT_MESSAGE);
    }

    public static void showRacingStatus(List<Car> cars) {
        for (Car car: cars) {
            showMessageWithNewLine(String.format("%5s: %s", car.getName(), car.toPositionString()));
        }
        showMessageWithNewLine("");
    }

    public static void showRacingResult(List<String> winner) {
        String winners = String.join(NAME_DELIMITER, winner);
        showSystemMessageWithNewLine(winners + FINAL_WINNER_MESSAGE);
    }
}
