package utils;

import domain.Winners;

import java.util.StringJoiner;

public class OutPutUtil {
    public static void printRacingCarsNameDemand() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askAttempTime() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printWinners(Winners winners) {
        StringJoiner sj = new StringJoiner(", ");
        winners.getWinners().stream()
                .forEach(car -> sj.add(car.getCarOriginName()));
        System.out.println(sj + "가 최종 우승했습니다.");
    }

}
