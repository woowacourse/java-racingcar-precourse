package racingcar;

import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
    	GameController mainGame= new GameController();
    	mainGame.play();
    }
}
