package racingcar.view;

import racingcar.domain.Cars;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public Cars readCarName() {
        return Cars.createCarNameByWord(readLine());
    }
}
