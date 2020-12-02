package racingcar;

import java.util.Scanner;

/**
 * @author yhh1056
 * @since 2020/12/02
 */
public class RacingController {
    private Input input;

    public RacingController(Scanner scanner) {
        this.input = new Input(scanner);
    }

    public void playGame() {
        String names = input.nextLine();
    }
}
