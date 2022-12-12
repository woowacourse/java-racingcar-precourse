package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Util;
import racingcar.util.Validator;

public class InputView {

    public String readCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        Validator.validateCarName(carNames);
        return carNames;
    }

    public int readGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Util.convertStringToInt(Console.readLine());
    }
}
