package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.TryCommand;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public Cars readCarName() {
        return Cars.createCarNameByWord(readLine());
    }

    public TryCommand readTryCommand() {
        return TryCommand.createTryCommandByString(readLine());
    }
}
