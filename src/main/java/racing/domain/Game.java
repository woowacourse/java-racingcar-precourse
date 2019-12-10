package racing.domain;

import racing.display.OutputDisplay;

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
        System.out.println("\n실행 결과");
        for (int i = 0; i < round; i++) {
            playOneRound();
            printCarStatus();
        }
    }

    private void playOneRound() {
        cars.playOneRoundWith(runRule);
    }

    private void printCarStatus() {
        OutputDisplay.printCarsStatus(cars);
    }

    public Winner getWinners() {
        return null;
    }
}
