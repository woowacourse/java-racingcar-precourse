import util.InputValidator;
import util.StringUtil;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GameApplication {
    private static final int COUNT_MIN = 1;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Host gameHost = new Host(outputView);
    private int count = COUNT_MIN;

    public static void main(String[] args) {
        GameApplication racingCarGame = new GameApplication();
        racingCarGame.start();
        racingCarGame.closeGame();
    }

    private void start() {
        initCars();
        initCount();
        gameHost.startGame(count);
    }

    private void initCars() {
        String cars = inputView.inputCars();

        List<String> namesInfo = StringUtil.getListFromString(cars);
        namesInfo = StringUtil.removeBlank(namesInfo);
        gameHost.addParticipants(namesInfo);
    }

    private void initCount() {
        while (true) {
            String input = inputView.inputCount();

            if (InputValidator.isNumberInRange(input, COUNT_MIN)) {
                this.count = Integer.parseInt(input);
                break;
            }

            inputView.printCountError();
        }
    }

    private void closeGame() {
        inputView.close();
    }
}
