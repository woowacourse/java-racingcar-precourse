package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.Result;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        List<Car> cars = CarFactory.manufactureByUserInput();
        int trial = getTrial();
        Result result = race(cars, trial);
        System.out.println("최종 우승자 : " + result);
    }

    private static Result race(List<Car> cars, int trial) {
        System.out.println("실행결과");
        for (int i = 0; i < trial; i++) {
            for (Car car : cars) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                car.attemptMove(randomNumber);
                System.out.println(car);
            }
            System.out.println();
        }
        return new Result(cars);
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
