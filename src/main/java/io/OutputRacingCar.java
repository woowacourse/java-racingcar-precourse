package io;

import domain.Car;

import java.util.List;

public class OutputRacingCar {
    public static void printGameResult() {
        System.out.println("실행 결과");
    }

    public static void printCarProgress(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i <= car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(List<String> winnerList) {
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i));
            if (i == winnerList.size() - 1) break;
            System.out.print(", ");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
