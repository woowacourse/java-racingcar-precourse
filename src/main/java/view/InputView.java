package view;

import java.util.Scanner;

public class InputView {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 횟수는 몇회인가요?";

    public String[] inputCarName(Scanner scanner) {
        System.out.println(START_MESSAGE);
        return dataSplit(scanner.nextLine());
    }

    public int inputNumberOfAttempts(Scanner scanner) {
        System.out.println(NUMBER_OF_ATTEMPTS_MESSAGE);
        return scanner.nextInt();
    }

    private String[] dataSplit(String data) {
        return data.split(",");
    }
}
