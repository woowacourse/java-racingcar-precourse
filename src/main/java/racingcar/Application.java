package racingcar;

import domain.CarList;
import domain.Turn;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        Game game = set();
        game.start();
    }

    public static Game set(){
        CarList carList = new CarList();
        Turn turns = new Turn(0);
        try {
            carList = InputView.getCarList();
            turns = InputView.getTimes();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            set();
        }
        Game game = new Game(carList,turns);
        return game;
    }
}
