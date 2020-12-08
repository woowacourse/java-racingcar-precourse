package service;

import java.util.Scanner;

public class InputService {
    private static final String SEPARATOR = ",";

    public static String[] getCarNames(Scanner scanner) {
        String[] carNames;

        while(true){
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String input = scanner.nextLine();
                carNames = input.split(SEPARATOR);
                break;
            } catch (Exception e) {
                System.out.println("[ERROR]"+e);
            }
        }

        return carNames;
    }
}
