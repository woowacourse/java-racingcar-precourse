package racingcar.domain;

public class RacingGameGeneratorProxy implements RacingGameGenerator {

    private final RacingGameGenerator racingGameGenerator;

    public RacingGameGeneratorProxy(RacingGameGenerator racingGameGenerator) {
        this.racingGameGenerator = racingGameGenerator;
    }

    @Override
    public Cars createCars() {
        try {
            return racingGameGenerator.createCars();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return createCars();
        }
    }

    @Override
    public CountOfMoves createCountOfMoves() {
        try {
            return racingGameGenerator.createCountOfMoves();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return createCountOfMoves();
        }
    }

    private void printErrorMessage(String exceptionMessage) {
        System.out.printf("[ERROR] %s\n", exceptionMessage);
    }

}
