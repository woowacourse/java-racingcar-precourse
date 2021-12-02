package racingcar;

import domain.CarList;
import domain.Turn;
import input.Client;

public class Application {
    public static void main(String[] args) {
        Game game = set();
        game.start();
    }

    public static Game set(){
        CarList carList = Client.getCarList();
        Turn turns = Client.getTimes();

        Game game = new Game(carList,turns);
        return game;
    }
}
