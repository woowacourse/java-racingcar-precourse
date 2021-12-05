package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public UserInput() {
    }

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carValue = Console.readLine();
        return carValue;
    }

    public String inputTry(){
        System.out.println("시도할 회수는 몇회인가요?");

        String tryValue = Console.readLine();
        return tryValue;
    }

}
