package racingcar;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final String ERROR = "[ERROR]";

    public static void main(String[] args) {
        Cars cars = getCarsWithUserInput();
        int numberOfAttempts = Integer.parseInt(inputView.enterNumberOfAttempts());

        outputView.printResult(cars, numberOfAttempts);
        outputView.printWinners(cars);
    }

    private static Cars getCarsWithUserInput() {
        Cars cars;

        try {
            cars = new Cars(inputView.enterCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR + " " + e.getMessage());
            cars = getCarsWithUserInput();
        }

        return cars;
    }
}
