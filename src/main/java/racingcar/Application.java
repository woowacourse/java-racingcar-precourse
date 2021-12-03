package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        String[] seperatedNames;
        String trialInput;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNamesInput = Console.readLine();
            seperatedNames = carNamesInput.split(",");
        } while (isIllegalName(seperatedNames));

        do {
            System.out.println("시도할 횟수는 몇회인가요?");
            trialInput = Console.readLine();
        } while (isIllegalTrial(trialInput));
    }

    private static boolean isIllegalTrial(String trialInput) {
        try {
            assertNumericOtherwiseRethrowException(trialInput);
            assertPositiveValue(trialInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    private static void assertPositiveValue(String trialInput) {
        int intValue = Integer.parseInt(trialInput);
        if (intValue < 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 양수여야 합니다.");
        }
    }

    private static void assertNumericOtherwiseRethrowException(String trialInput) {
        try {
            Integer.parseInt(trialInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }

    }

    private static boolean isIllegalName(String[] seperatedNames) {
        try {
            for (String name : seperatedNames) {
                if (name.length() > 5) {
                    throw new IllegalArgumentException("[ERROR] 자동차 이름의 크기는 5를 초과할 수 없습니다. 현재 자동차 이름 = " + name);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }
}
