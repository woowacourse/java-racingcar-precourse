package racingcar.domain;

public class RacingGameGeneratorProxy extends RacingGameGeneratorImpl {

    private final RacingGameGeneratorImpl racingGameGeneratorImpl;

    public RacingGameGeneratorProxy(RacingGameGeneratorImpl racingGameGeneratorImpl) {
        super(null);
        this.racingGameGeneratorImpl = racingGameGeneratorImpl;
    }

    @Override
    protected Cars createCars() {
        try {
            return racingGameGeneratorImpl.createCars();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return createCars();
        }
    }

    @Override
    protected CountOfMoves createCountOfMoves() {
        try {
            return racingGameGeneratorImpl.createCountOfMoves();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return createCountOfMoves();
        }
    }

    private void printErrorMessage(String exceptionMessage) {
        System.out.printf("[ERROR] %s\n", exceptionMessage);
    }

}
