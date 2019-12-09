package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            return scanner.nextLine();
        } catch (Exception e) {
            return inputCarNames();
        }
    }

    public static int inputRacingRounds() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return inputRacingRounds();
        }
    }
}