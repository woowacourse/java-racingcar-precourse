package racingcar.view;

import racingcar.view.input.Reader;

public class CustomReader implements Reader {

    String inputString;

    public void initInputString(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String readLine() {
        return inputString;
    }

}
