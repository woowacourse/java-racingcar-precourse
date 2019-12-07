package util;

import domain.RacingCar;
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
    public void printStateOfRacingCar(RacingCar racingCar) {
        System.out.println(racingCar + " : " + StringUtils.repeat(RacingGameConfig.POSITION_MARK, racingCar.getPosition()));
    }

    @Override
    public void printWinners(List<RacingCar> winners) {
        String format = buildFormat(winners.size());
        System.out.println(String.format(format, winners.toArray()));
    }

    @Override
    public void printOneCycleFinished() {
        System.out.println();
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
