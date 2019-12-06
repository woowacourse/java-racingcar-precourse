package io;

import domain.Car;

import java.util.List;

public class OutputRacingCar {
    public static void printGameResult() {
        System.out.println("\n실행 결과");
    }

    public static void printCarProgress(Car car) {
        StringBuilder sb = new StringBuilder();

        sb.append(car.getName());
        sb.append(" : ");
        printPositionStatus(sb, car);
        System.out.println(sb);
    }

    public static void printPositionStatus(StringBuilder sb, Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
    }

    public static void printWinner(List<String> winnerList) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < winnerList.size(); i++) {
            sb.append(winnerList.get(i));
            if (i == winnerList.size() - 1) break;
            sb.append(", ");
        }
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
