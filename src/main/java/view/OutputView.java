/*
 * OutputView.java
 *
 * v 0.0.0
 *
 * 2019.12.07
 *
 * Copyright 2019. DunDung all rights reserved.
 */

package view;

import domain.GameResult;
import domain.RaceResults;

public class OutputView {
    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String FINAL_WIN = "가 최종 우승했습니다.";
    private static final String NEW_LINE = "\n";

    public void printRaceResults(RaceResults raceResults) {
        println(NEW_LINE + EXECUTE_RESULT);
        print(raceResults.toString());
    }

    public void printGameResult(GameResult gameResult) {
        StringBuilder builder = new StringBuilder(gameResult.getGameResult());
        builder.append(FINAL_WIN);
        print(builder.toString());
    }

    public void printException(Exception e) {
        println(e.getMessage() + NEW_LINE);
    }

    private void println(String text) {
        System.out.println(text);
    }

    private void print(String text) {
        System.out.print(text);
    }
}
