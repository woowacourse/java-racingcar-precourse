package racingcar.view;

public class DefaultView {

    private final OutputView outputView;
    private final InputView inputView;

    public DefaultView(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void render() {
        outputView.printInputCarNameMessage();
        String carNames = inputView.readInput();
    }
}
