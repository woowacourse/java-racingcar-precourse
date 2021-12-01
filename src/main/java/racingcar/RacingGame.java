package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

public class RacingGame {
    private Player player;

    public RacingGame() {
        this.player = new Player();
    }

    public void startGame(){
        String[] carNamesArray =  player.startGame();
        for (String carName : carNamesArray) {
            System.out.println(carName);
        }
    }
}
