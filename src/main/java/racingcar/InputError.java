package racingcar;

import java.io.IOException;

public class InputError {
    public static boolean carName() throws IOException {
        if (InputView.getCarName().length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하로 지정하여 주세요.");

            return InputView.getCarName();
        }
    }
}
