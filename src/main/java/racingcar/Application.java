package racingcar;

import domain.CarList;
import domain.Turn;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        Game game = set();
        game.start();
    }

    private static Game set(){
        CarList carList = setCarList();
        Turn turns = setTurns();

        Game game = new Game(carList,turns);
        return game;
    }

    private static CarList setCarList(){
        CarList carList = new CarList();
        try{
            carList = InputView.getCarList();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            setCarList();
        }
        return carList;
    }

    private static Turn setTurns(){
        Turn turns = new Turn(0);
        try {
            turns = InputView.getTimes();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setTurns();
        }
        return turns;
    }

}
