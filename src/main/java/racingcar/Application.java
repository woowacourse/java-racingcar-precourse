package racingcar;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        Cars cars = getCarsWithUserInput();
        int numberOfTimes = Integer.parseInt(getNumberOfTimes());

        outputView.printResult(cars, numberOfTimes);
        outputView.printWinners(cars);
    }

    public static Cars getCarsWithUserInput() {
        Cars cars;

        try {
            cars = new Cars(inputView.getCarNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            cars = getCarsWithUserInput();
        }

        return cars;
    }

    public static String getNumberOfTimes() {
        String numberOfTimes;

        try {
            numberOfTimes = inputView.getNumberOfTimes();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            numberOfTimes = getNumberOfTimes();
        }

        return numberOfTimes;
    }

}
