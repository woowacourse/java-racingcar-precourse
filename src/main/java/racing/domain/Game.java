package racing.domain;

public class Game {
    private final CarList cars;
    private final CarRunRule runRule;

    private Game(CarList cars, CarRunRule runRule) {
        this.cars = cars;
        this.runRule = runRule;
    }

    public static Game of(CarList cars, CarRunRule runRule) {
        return new Game(cars, runRule);
    }

    public void playOneRound() {
        cars.playOneRoundWith(runRule);
    }

    public Winner getWinners() {
        return cars.getWinners();
    }

    public CharSequence getCurrentInfo() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars) {
            stringBuilder.append(car);
            stringBuilder.append('\n');
        }

        return stringBuilder;
    }
}
