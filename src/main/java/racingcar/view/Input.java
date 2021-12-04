package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.RepetitionNumber;

public class Input {
    private Input() {
    }

    public static Cars inputCarNames() {
        try {
            Output.CarNameInputGuideMessage();
            return new Cars(Console.readLine());
        } catch (IllegalArgumentException e) {
            return inputCarNames();
        }
    }

    public static RepetitionNumber inputRepetitionNumber() {
        try {
            Output.NumberInputGuideMessage();
            return new RepetitionNumber(Console.readLine());
        } catch (IllegalArgumentException e) {
            return inputRepetitionNumber();
        }
    }
}
