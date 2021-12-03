package racingcar;

import racingcar.domain.GameBoy;
import racingcar.domain.Token;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameBoy gameBoy = init();
        Token token = createToken();
        gameBoy.insertToken(token);
        gameBoy.play();
        OutputView.print(gameBoy.showResult());
    }

    private static GameBoy init() {
        try {
            return new GameBoy(InputView.inputNames());
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            return init();
        }
    }

    private static Token createToken() {
        try {
            return Token.from(InputView.inputCount());
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            return createToken();
        }
    }
}
