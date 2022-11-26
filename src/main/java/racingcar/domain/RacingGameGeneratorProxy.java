package racingcar.domain;

public class RacingGameGeneratorProxy implements RacingGameGenerator {

    private final RacingGameGenerator RacingGameGenerator;

    public RacingGameGeneratorProxy(RacingGameGenerator racingGameGenerator) {
        this.RacingGameGenerator = racingGameGenerator;
    }

    @Override
    public Cars createCars() {
        try {
            return RacingGameGenerator.createCars();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return createCars();
        }
    }

    @Override
    public CountOfMoves createCountOfMoves() {
        try {
            return RacingGameGenerator.createCountOfMoves();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return createCountOfMoves();
        }
    }

    private void printErrorMessage(String exceptionMessage) {
        System.out.printf("[ERROR] %s\n", exceptionMessage);
    }

}
