package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.RepetitionNumber;
import racingcar.domain.exception.Validator;

public class Input {
    public Validator validator;

    public Input(Validator validator) {
        this.validator = validator;
    }

    public Cars inputCarNames() {
        try {
            Output.carNameInputGuideMessage();
            return new Cars(Console.readLine(), validator);
        } catch (IllegalArgumentException e) {
            return inputCarNames();
        }
    }

    public RepetitionNumber inputRepetitionNumber() {
        try {
            Output.numberInputGuideMessage();
            return new RepetitionNumber(Console.readLine(), validator);
        } catch (IllegalArgumentException e) {
            return inputRepetitionNumber();
        }
    }
}
