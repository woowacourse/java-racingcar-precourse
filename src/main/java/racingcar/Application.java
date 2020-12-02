package racingcar;

import view.ConsoleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final String REQUEST_INPUT_RACING_CAR_MSG = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String COMMA = ",";
    private List<Car> cars;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Application app = new Application();
        app.start(scanner);
    }

    private void start(Scanner scanner) {
        ConsoleView view = new ConsoleView(scanner);
        view.println(REQUEST_INPUT_RACING_CAR_MSG);
        String userInput = view.inputNextLine();
        String[] carNames = userInput.split(COMMA);

        cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}
