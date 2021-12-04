package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements Reader {

    @Override
    public String readLine() {
        return Console.readLine();
    }

}
