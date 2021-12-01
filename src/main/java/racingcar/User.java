package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.Validator.validateCarNames;

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
}
