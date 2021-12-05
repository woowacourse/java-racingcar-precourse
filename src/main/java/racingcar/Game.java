package racingcar;


import domain.Car;
import domain.CarList;
import domain.Turn;
import view.InputView;
import view.OutputView;


public class Game {
    private CarList cars;
    private int turns;

    public Game() {
        setCarList();
        setTurns();
    }

    public void start() {
        for (int i = 0; i < turns; i++) {
            for (Car car : cars.getCarList()) {
                car.goOrStop();
                OutputView.printNow(cars.getCarList());
            }
        }
        OutputView.printEnd(cars.decideWinner());
    }

    private void setCarList() {
        try {
            String inputCars = InputView.getCarList();
            this.cars = new CarList(inputCars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setCarList();
        }
    }

    public void setTurns() {
        try {
            String inputTurns = InputView.getTurns();
            this.turns = new Turn(inputTurns).getTurns();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setTurns();
        }
    }
}
