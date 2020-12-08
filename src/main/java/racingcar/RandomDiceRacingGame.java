package racingcar;

import utils.RandomUtils;

public class RandomDiceRacingGame implements IRacingGame {
    private final IRacingGamePlayers players;
    private final IRacingGamePrinter printer;
    private int reps = 0;

    public RandomDiceRacingGame(IRacingGamePlayers players, IRacingGamePrinter printer) {
        this.players = players;
        this.printer = printer;
    }

    @Override
    public void readyForSetCars() {
        printer.inputNames();
    }

    @Override
    public boolean trySetCars(String names) {
        if (!players.trySetCars(names)) {
            printer.errorInputPlayer();
            return false;
        }
        return true;
    }

    @Override
    public void readyForSetReps() {
        printer.inputReps();
    }

    @Override
    public boolean trySetReps(String reps) {
        try {
            if ((0 < Integer.parseInt(reps)) && (Double.parseDouble(reps) <= Integer.MAX_VALUE)) {
                this.reps = Integer.parseInt(reps);
                return true;
            }
        } catch (NumberFormatException ignored) {
        }
        printer.errorInputReps();
        return false;
    }

    @Override
    public void start() {
        printer.start();
        for (int i = 0; i < reps; i++) {
            race();
            printer.status(players.getCars());
        }
    }

    private void race() {
        for (Car car : players.getCars()) {
            if (RandomUtils.nextInt(0, 9) > 3) {
                car.drive();
            }
        }
    }
}