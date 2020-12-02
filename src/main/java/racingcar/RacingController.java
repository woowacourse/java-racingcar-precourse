package racingcar;

import java.util.List;
import java.util.Scanner;

/**
 * @author yhh1056
 * @since 2020/12/02
 */
public class RacingController {
    private Input input;
    private User user;

    public RacingController(Scanner scanner) {
        this.input = new Input(scanner);
        this.user = new User();
    }

    public void playGame() {
        List<String> names = user.createNames(input.nextLine());
    }
}
