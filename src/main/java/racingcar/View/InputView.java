package racingcar.View;

import racingcar.Domain.Cars;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static Cars readCarName(){

        return Cars.createCarByName(readLine());
    }
}
