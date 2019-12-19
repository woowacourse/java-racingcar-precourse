package utils;

import domain.RacingCars;
import domain.Winners;
import utils.dto.RacingCarsFormatConverter;
import utils.dto.WinnersFormatConverter;

import java.util.StringJoiner;

public class OutputUtil {
    public static void printRacingCarsNameDemand() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAttempTimeQUestion() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printUnEmptyWinners(Winners winners) {
        // TODO : OutputUtil에서만 포맷을 컨버팅하는 클래스들 생성
        StringJoiner sj = WinnersFormatConverter.convertWinnersFormat(winners);
        System.out.println(sj + "가(이) 최종 우승했습니다.");
    }

    public static void printWinners(Winners winners) {
        if (winners.isNoWinner()) {
            printNoneWinners();
            return;
        }
        printUnEmptyWinners(winners);
    }

    public static void printNoneWinners() {
        System.out.println("최종 우승자가 없습니다!");
    }

    public static void printRacingSituation(RacingCars racingCars) {
        // TODO : OutputUtil에서만 포맷을 컨버팅하는 클래스들 생성
        String racingCarsFormat =
                RacingCarsFormatConverter.convertRacingCarsFormat(racingCars);
        System.out.println("실행 결과 \n" + racingCarsFormat);
    }
}
