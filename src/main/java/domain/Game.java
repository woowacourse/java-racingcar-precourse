package domain;

import view.InputView;

public class Game {
    private CarList cars;
    private int turns;

    public Game() {
        setCarList();
        setTurns();
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

    public int getTurns() {
        return this.turns;
    }

    public CarList getCars() {
        return this.cars;
    }
}
