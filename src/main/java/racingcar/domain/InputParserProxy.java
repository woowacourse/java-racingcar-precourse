package racingcar.domain;

public class InputParserProxy implements InputParser {

    private final InputParser inputParser;

    public InputParserProxy(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    @Override
    public Cars createCars() {
        try {
            return inputParser.createCars();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return createCars();
        }
    }

    @Override
    public CountOfMoves createCountOfMoves() {
        try {
            return inputParser.createCountOfMoves();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return createCountOfMoves();
        }
    }

    private void printErrorMessage(String exceptionMessage) {
        System.out.printf("[ERROR] %s\n", exceptionMessage);
    }

}
