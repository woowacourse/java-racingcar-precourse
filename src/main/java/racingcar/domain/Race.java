package racingcar.domain;


public class Race {
    private final Cars cars;
    private Cars winnerCars;
    private int maxDistance;
    private int moveCount;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public void run() {
        execute();
        calculateMaxDistance();
        decideWinner();
        showWinner();
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    private void calculateMaxDistance() {
        maxDistance = cars.calculateMaxDistance();
    }

    private void decideWinner() {
        winnerCars = this.cars.decideWinner(maxDistance);
    }

    private void execute() {
        cars.executeRound(moveCount);
    }

    private void showWinner() {
        winnerCars.showWinner();
    }

}
