package racingcar;

import view.ConsoleView;

import java.util.Scanner;

public class Application {
    private static final String REQUEST_INPUT_RACING_CAR_MSG = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_INPUT_ROUND_MSG = "시도할 횟수는 몇 회인가요?";
    private static final String COMMA = ",";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Application app = new Application();
        app.start(scanner);
    }

    private void start(Scanner scanner) {
        ConsoleView view = new ConsoleView(scanner);

        view.println(REQUEST_INPUT_RACING_CAR_MSG);
        Cars cars = createCars(view.inputNextLine());

        view.println(REQUEST_INPUT_ROUND_MSG);
        int round = view.inputNextInt();
        Racing racing = new Racing(cars, round);

        while (racing.hasNextRound()) {
            racing.nextRound();
            view.println(racing.printProgress());
        }
        view.println(racing.printResult());
    }

    private Cars createCars(String userInput) {
        String[] carNames = userInput.split(COMMA);
        return CarsFactory.createCars(carNames);
    }
}
