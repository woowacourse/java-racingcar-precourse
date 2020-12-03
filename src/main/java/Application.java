import controller.RacingCarGameController;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        final InputView inputView = new InputView(scanner);
        final OutputView outputView = new OutputView();
        final RacingCarGameController racingCarGameController = new RacingCarGameController(inputView, outputView);
        racingCarGameController.run();
    }
}
