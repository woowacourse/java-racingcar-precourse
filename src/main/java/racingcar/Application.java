package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행

        List<Car> cars = CarFactory.manufactureByUserInput();
        int trialInput = getTrial();
    }

    private static int getTrial() {
        String trialInput;
        do {
            System.out.println("시도할 횟수는 몇회인가요?");
            trialInput = Console.readLine();
        } while (isIllegalTrial(trialInput));

        return Integer.parseInt(trialInput);
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

}
