package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        RacingCars racingCars;
        int trialsTimes;

        try {
            racingCars = readCarNames(scanner);
            trialsTimes = readTrialNum(scanner);
            takeRaceRounds(racingCars, trialsTimes);
            GameStatus.printWinner(racingCars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static RacingCars readCarNames(Scanner scanner) {
        final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

        System.out.println(INPUT_CAR_NAME);
        return new RacingCars(InputManager.readCarList(scanner.nextLine()));
    }

    private static int readTrialNum(Scanner scanner) {
        final String INPUT_TRIAL_NUM = "시도할 회수는 몇회인가요?";

        System.out.println(INPUT_TRIAL_NUM);
        return InputManager.readTrialNum(scanner.nextLine());
    }

    private static void takeRaceRounds(RacingCars racingCars, int trialTimes) {
        System.out.println("\n실행 결과");
        for (int round = 0; round < trialTimes; round++) {
            racingCars.takeOneRound();
            GameStatus.printStatus(racingCars);
        }
    }
}
