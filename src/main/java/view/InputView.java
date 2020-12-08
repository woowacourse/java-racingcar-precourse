package view;

import java.util.Scanner;

/**
 * 입력을 담당하는 객체
 *
 * @author 조연우
 * @version 1.0 2020년 12월 8일
 */
public class InputView {
    public static final String PRINT_RECEIVE_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String PRINT_RECEIVER_COUNT = "시도할 회수는 몇회인가요?";
    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public String receiveNames() {
        System.out.println(PRINT_RECEIVE_NAMES);
        return this.scanner.nextLine();
    }

    public String receiveCounts() {
        System.out.println(PRINT_RECEIVER_COUNT);
        return this.scanner.nextLine();
    }
}
