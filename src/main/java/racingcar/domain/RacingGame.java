package racingcar.domain;

import racingcar.domain.car.NumberGenerator;

public class RacingGame {

    private static final int GAME_OVER_COUNT = 0;

    private final Player player;
    private int gameRound;

    public RacingGame(Player player, int gameRound) {
        this.player = player;
        this.gameRound = gameRound;
    }

    public void play(NumberGenerator numberGenerator) {
        player.playOneRound(numberGenerator);
        gameRound--;
    }

    public boolean isGameContinue() {
        return (gameRound != GAME_OVER_COUNT);
    }
}
