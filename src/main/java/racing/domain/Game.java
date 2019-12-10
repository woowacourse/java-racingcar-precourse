package racing.domain;

public class Game {
    private final CarList cars;
    private final CarRunRule runRule;

    private Game(CarList cars, CarRunRule runRule) {
        this.cars = cars;
        this.runRule = runRule;
    }

    public static Game getInstance(CarList cars, CarRunRule runRule) {
        return new Game(cars, runRule);
    }

    public void start(int round) {
        for (int i = 0; i < round; i++) {
            playOneRound();
            printCarStatus();
        }
    }

    private void playOneRound() {

    }

    private void printCarStatus() {

    }

    public Winner getWinners() {
        return null;
    }
}
