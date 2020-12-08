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
                checkCarNames(carNames);
                break;
            } catch (Exception e) {
                System.out.println("[ERROR]"+e.getMessage());
            }
        }
        return carNames;
    }

    private static void checkCarNames(String[] carNames) {
        for (String carName : carNames) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if(carName.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백이 아니어야 합니다.");
            }
        }
    }
}
