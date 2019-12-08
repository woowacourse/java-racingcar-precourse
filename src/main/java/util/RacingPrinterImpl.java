package util;

import domain.Raceable;
import domain.RacingGameConfig;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class RacingPrinterImpl implements RacingPrinter {
    @Override
    public void printStartSign() {
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
}
