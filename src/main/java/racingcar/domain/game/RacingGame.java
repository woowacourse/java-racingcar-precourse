package racingcar.domain.game;

import racingcar.domain.car.Cars;
import racingcar.domain.dto.CarDto;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final GameState gameState;

    public RacingGame(Cars cars, GameState gameState) {
        this.cars = cars;
        this.gameState = gameState;
    }

    public void race() {
        this.gameState.decreaseRacingTryCount();
        this.cars.move();
    }

    public boolean isEnd() {
        return this.gameState.isEnd();
    }

    public List<CarDto> getCarDtos() {
        return this.cars.getCarDtos();
    }

    public List<String> getWinnerCarNames() {
        return this.cars.getWinnerCarNames();
    }
}
