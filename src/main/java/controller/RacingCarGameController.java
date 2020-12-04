package controller;

import domain.CountValidator;
import domain.NameValidator;
import domain.UnitGame;
import domain.Winner;
import domain.racingcar.Car;
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
        List<Car> cars = carFactory.makeCars(Objects.requireNonNull(makeNames()));
        UnitGame unitGame = new UnitGame(cars);
        int c = makeCounts();
        this.outputView.printResult();
        for (int i = 0; i < c; i++) {
            unitGame.makeRandomNumbers();
            cars.forEach(car -> this.outputView.printNowCars(car.getName(), car.getPosition()));
            this.outputView.printOneLine();
        }
        this.outputView.printWinner(Winner.makeWinners(cars));
    }

    private int makeCounts() {
        try {
            CountValidator countValidator = new CountValidator(this.inputView.receiveCounts());
            return countValidator.makeValidCount();
        } catch (IllegalArgumentException e) {
            this.outputView.printError(e.getMessage());
            makeCounts();
        }
        return 0;
    }

    private List<String> makeNames() {
        try {
            NameValidator nameValidator = new NameValidator(this.inputView.receiveNames());
            return nameValidator.makeDataToNames();
        } catch (IllegalArgumentException e) {
            this.outputView.printError(e.getMessage());
            makeNames();
        }
        return null;
    }
}
