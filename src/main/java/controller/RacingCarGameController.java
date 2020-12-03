package controller;

import domain.NameValidator;
import domain.racingcar.CarFactory;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Objects;

public class RacingCarGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        CarFactory carFactory = new CarFactory();
        carFactory.makeCars(Objects.requireNonNull(makeNames()));
        System.out.println(this.inputView.receiveCounts());
    }

    private List<String> makeNames() {
        try{
            NameValidator nameValidator = new NameValidator(this.inputView.receiveNames());
            return nameValidator.makeDataToNames();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            makeNames();
        }
        return null;
    }
}
