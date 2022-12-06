package racingcar.domain;

public class RacingCarGame {

    private final Cars cars;

    public RacingCarGame(Cars cars) {
        this.cars = cars;
    }

    public void move() {
        cars.move(new CarRandomMoveNumberGenerator());
    }

    public Winner findWinner() {
        return cars.findWinner();
    }

    public Cars getCars() {
        return cars;
    }
}
