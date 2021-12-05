package controller;

import domain.Car;
import domain.CarList;
import domain.Game;
import view.OutputView;


public class GameController {

    final Game game = new Game();

    public void start() {
        int turns = game.getTurns();
        CarList cars = game.getCars();
        for (int i = 0; i < turns; i++) {
            for (Car car : cars.getCarList()) {
                car.goOrStop();
                OutputView.printNow(cars.getCarList());
            }
        }
        OutputView.printEnd(cars.decideWinner());
    }
}
