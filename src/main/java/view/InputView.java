package view;

import java.util.Scanner;

public class InputView {
    private static final String MSG_REQUEST_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MSG_REQUEST_COUNT = "시도할 회수는 몇회인가요?";
    private static final String MSG_COUNT_ERROR = "시도할 횟수는 1 이상의 정수여야 합니다";
    private final Scanner scanner = new Scanner(System.in);

    public String inputCars() {
        System.out.println(MSG_REQUEST_CARS);
        return scanner.nextLine();
    }

    public String inputCount() {
        System.out.println(MSG_REQUEST_COUNT);
        return scanner.nextLine();
    }

    public void printCountError() {
        System.out.println(MSG_COUNT_ERROR);
    }

    public void close() {
        scanner.close();
    }
}
