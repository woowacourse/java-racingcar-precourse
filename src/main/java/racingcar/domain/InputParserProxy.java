package racingcar.domain;

import racingcar.view.InputView;

public class InputParserProxy implements InputParser {

    private final InputParser inputParser;

    public InputParserProxy(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    @Override
    public Cars createCars(InputView inputView) {
        try {
            return inputParser.createCars(inputView);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return createCars(inputView);
        }
    }

    @Override
    public CountOfMoves createCountOfMoves(InputView inputView) {
        try {
            return inputParser.createCountOfMoves(inputView);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return createCountOfMoves(inputView);
        }
    }

    private void printErrorMessage(String exceptionMessage) {
        System.out.printf("[ERROR] %s\n", exceptionMessage);
    }

}
