package game;

import domain.Car;
import service.GameService;
import java.util.ArrayList;

/**
 * 자동차 경주 게임 실행
 *
 * @version 1.0(2019.04.01)
 * @author  김종윤
 */
public class RacingGame {
    /*
    * 구현기능
    * 1.게임 진행
    */
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.playGame();
    }

    public void playGame() {
        GameService gameService = new GameService();
        String[] names = gameService.inputAndProcessNames();
        ArrayList<Car> registeredCars = gameService.registerCars(names);
        gameService.runningRace(registeredCars);
        gameService.printWinner(gameService.checkWinner(registeredCars));
    }
}
