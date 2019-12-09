/*
 *  @RacingGameController.java
 *
 *  @Version: 0.1
 *
 *  @Date: 2019.12.06
 *
 *  @Author: pandahun
 */

import domain.RacingGame;

public class RacingGameController {

    public static void main( String[] args ) {
        RacingGame racingGame = RacingGame.init();
        racingGame.run();
    }
}
