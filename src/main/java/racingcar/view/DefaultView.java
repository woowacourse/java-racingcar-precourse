package racingcar.view;

public class DefaultView {

    private final OutputView outputView;

    public DefaultView(OutputView outputView) {
        this.outputView = outputView;
    }

    public void render() {
        outputView.printInputCarNameMessage();
    }
}
