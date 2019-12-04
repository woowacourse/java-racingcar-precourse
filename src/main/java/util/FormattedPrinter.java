package util;

import java.util.List;
import java.util.Scanner;

import domain.Car;

public class FormattedPrinter {
    static void printLine(Object obj) {
        System.out.println(obj);
    }

    private static void printLine() {
        System.out.println();
    }

    public static String askForNames(Scanner scanner) {
        printLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine();
    }

    public static int askForTimes(Scanner scanner) {
        printLine("시도할 회수는 몇회인가요?");
        String timesInString = scanner.nextLine();
        return ExceptionHandler.askForTimesHandler(timesInString, scanner);
    }

    public static void printResult() {
        printLine();
        printLine("실행결과");
    }

    public static void printWinners(List<String> winners) {
        printLine(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            printLine(car);
        }
        printLine();
    }
}
