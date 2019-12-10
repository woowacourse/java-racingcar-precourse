package utils;

import domain.RacingCars;
import domain.Winners;

import java.util.StringJoiner;

public class OutputUtil {
    private static final String MINUS = "-";

    public static void printRacingCarsNameDemand() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askAttempTime() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printWinners(Winners winners) {
        StringJoiner sj = new StringJoiner(", ");
        winners.getWinners()
                .forEach(car -> sj.add(car.getCarOriginName()));
        System.out.println(sj + "가(이) 최종 우승했습니다.");
    }

    public static void printNoneWinners() {
        System.out.println("최종 우승자가 없습니다!");
    }

    public static void printRacingSituation(RacingCars racingCars) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과").append('\n');
        racingCars.getRacingCars()
                .forEach(car -> {
                    sb.append(car.getCarOriginName()).append(" : ");
                    printMinus(car.getPosition(), sb);
                    sb.append('\n');
                });
        System.out.println(sb.toString());
    }

    private static void printMinus(Integer position, StringBuilder sb) {
        for (int i = 0; i < position; i++) {
            sb.append(MINUS);
        }
    }

}
