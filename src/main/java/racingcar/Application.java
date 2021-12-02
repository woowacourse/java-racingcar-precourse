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
        CarList carList = InputView.getCarList();
        Turn turns = InputView.getTimes();

        Game game = new Game(carList,turns);
        return game;
    }
}
