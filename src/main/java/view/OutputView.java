/*
 * OutputView.java
 *
 * version 1.1
 *
 * 2020/12/05
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package view;

import racingcar.domain.Car;

import java.util.ArrayList;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자:";

    public static void executionMessage() {
        System.out.println();
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void executionResult(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + racingRecord(car.getPosition()));
        }
    }

    public static void finalWinner(String[] winners) {
        System.out.print(WINNER_MESSAGE);
        System.out.println(concatResult(winners));
    }

    private static String concatResult(String[] texts) {
        String result = "";
        for (String text : texts) {
            result += " " + text + ",";
        }
        return  result.substring(0, result.length() - 1);
    }

    private static String racingRecord(int count) {
        String record = "";
        for (int i = 0; i < count; i++) {
            record += "-";
        }
        return record;
    }
}
