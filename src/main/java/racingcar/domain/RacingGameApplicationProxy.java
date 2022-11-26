package racingcar.domain;

public class RacingGameApplicationProxy extends RacingGameApplication {

    private final RacingGameApplication racingGameApplication;

    public RacingGameApplicationProxy(RacingGameApplication racingGameApplication) {
        super(null, null);
        this.racingGameApplication = racingGameApplication;
    }

    @Override
    protected Cars createCars() {
        try {
            return racingGameApplication.createCars();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return createCars();
        }
    }

    @Override
    protected CountOfMoves createCount() {
        try {
            return racingGameApplication.createCount();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return createCount();
        }
    }

    private void printErrorMessage(String exceptionMessage) {
        System.out.printf("[ERROR] %s\n", exceptionMessage);
    }
}
