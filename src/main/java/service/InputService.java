package service;

import java.util.Scanner;

public class InputService {
    private static final String SEPARATOR = ",";
    private Scanner scanner;

    public InputService(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getCarNames() {
        String[] carNames;
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String input = scanner.nextLine();
                carNames = input.split(SEPARATOR);
                checkCarNames(carNames);
                break;
            } catch (Exception e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
        return carNames;
    }

    private void checkCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (carName.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백이 아니어야 합니다.");
            }
        }
    }

    public int getToTalPhaseNumber() {
        int totalPhaseNumber;
        while (true) {
            try {
                System.out.println("시도할 횟수는 몇회인가요?");
                String input = scanner.nextLine();
                totalPhaseNumber = checkTotalPhaseNumber(input);
                break;
            } catch (Exception e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
        return totalPhaseNumber;
    }

    private int checkTotalPhaseNumber(String input) {
        int totalPhaseNumber;

        try {
            totalPhaseNumber = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        if (totalPhaseNumber <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }

        return totalPhaseNumber;
    }
}
