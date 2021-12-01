package racingcar;

import static racingcar.Validator.validateCarNames;
import static racingcar.Validator.validateTrialNum;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public static String[] getCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        while (true) {
            try {
                String[] carNames = Console.readLine().split(",");
                validateCarNames(carNames);
                return carNames;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getTrialNumInput() {
        System.out.println("시도할 회수는 몇회인가요?");

        while (true) {
            try {
                String input = Console.readLine();
                validateTrialNum(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
