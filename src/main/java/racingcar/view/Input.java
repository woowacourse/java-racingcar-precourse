package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.RepetitionNumber;

public class Input {
    private Input() {
    }

    public static Cars inputCarNames() {
        try {
            Output.carNameInputGuideMessage();
            return new Cars(Console.readLine());
        } catch (IllegalArgumentException e) {
            return inputCarNames();
        }
    }

    public static RepetitionNumber inputRepetitionNumber() {
        try {
            Output.numberInputGuideMessage();
            return new RepetitionNumber(Console.readLine());
        } catch (IllegalArgumentException e) {
            return inputRepetitionNumber();
        }
    }
}
