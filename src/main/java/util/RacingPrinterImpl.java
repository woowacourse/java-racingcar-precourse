/*
 * @(#)RacingPrinterImpl.java 2019/12/10
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import domain.Raceable;
import domain.RacingGameConfig;

public class RacingPrinterImpl implements RacingPrinter {
    @Override
    public void printStartGameSign() {
        System.out.println();
        System.out.println("실행 결과");
    }

    @Override
    public void printStateOfRacingCar(Raceable raceable) {
        System.out.println(raceable + " : " + StringUtils.repeat(RacingGameConfig.POSITION_MARK, raceable.getPosition()));
    }

    @Override
    public void printWinners(List<Raceable> winners) {
        String format = buildFormat(winners.size());
        System.out.println(String.format(format, winners.toArray()));
    }

    private String buildFormat(int size) {
        String format = "";
        for (int i = 0; i < size; i++) {
            if (i == (size - 1)) {
                format += "%s";
                continue;
            }
            //todo: change to stringBuilder
            format += "%s, ";
        }
        format += "가 최종 우승했습니다.";
        return format;
    }

    @Override
    public void printOneCycleFinished() {
        System.out.println();
    }

    @Override
    public void printRequestForNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void printRequestForCycles() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void printErrorWhenExtractingNames(RuntimeException e) {
        System.out.println(String.format("입력값이 옳바르지 않습니다. 다시 시도해주세요. 사유 - %s", e.getMessage()));
    }

    @Override
    public void printErrorWithTooSmallCycle(int minCycles) {
        System.out.println(String.format("입력값이 옳바르지 않습니다. 다시 시도해주세요. 사유 - %d 이상의 자연수여야 합니다.", minCycles));
    }

    @Override
    public void printErrorWithNotNaturalNumber() {
        System.out.println("입력값이 옳바르지 않습니다. 다시 시도해주세요. 사유 - 자연수가 아닙니다.");
    }

    @Override
    public void printErrorGameFinishedAbnormal(String message) {
        System.out.println(String.format("자동차 경주 게임이 다음과 같은 이유로 종료됐습니다: %s", message));
    }


}
