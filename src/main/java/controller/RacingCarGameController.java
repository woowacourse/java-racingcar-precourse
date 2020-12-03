package controller;

import domain.NameValidator;
import view.InputView;
import view.OutputView;

public class RacingCarGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        makeNames();
    }

    private void makeNames() {
        try{
            NameValidator nameValidator = new NameValidator(this.inputView.receiveNames());
            System.out.println(nameValidator.makeDataToNames());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            makeNames();
        }
    }
}
