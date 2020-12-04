/*
 * OutputView.java
 *
 * version 1.0
 *
 * 2020/12/04
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package view;

import java.util.HashMap;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자:";

    public static void executionResult(HashMap<String, Integer> playerRecord) {
        System.out.println(EXECUTION_RESULT_MESSAGE);
        for (String key : playerRecord.keySet()) {
            System.out.println(key + " : " + playerRecord.get(key));
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
}
