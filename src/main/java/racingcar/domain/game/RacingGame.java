package racingcar.domain.game;

import racingcar.domain.car.Cars;

public class RacingGame {

    private final Cars cars;
    private final GameState gameState;

    public RacingGame(Cars cars, GameState gameState) {
        this.cars = cars;
        this.gameState = gameState;
    }

    public void race() {
        gameState.decreaseRacingTryCounts();
        this.cars.move();
    }

    public boolean isEnd() {
        return this.gameState.isEnd();
    }
}
