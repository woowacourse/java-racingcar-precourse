package util;

import java.util.List;

import domain.Car;

public class FormattedPrinter {
    public static void askForNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askForTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResult() {
        System.out.println("\n실행결과");
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();       // 공백 줄 추가
    }
}
