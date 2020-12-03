package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAMES_PHRASE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";

    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Car> getCarNames() {
        System.out.print(INPUT_CAR_NAMES_PHRASE);
        return parse(validated());
    }

    private List<Car> parse(String validatedInput) {
        List<Car> parsedCars = new ArrayList<>();
        for (String s : validatedInput.split(InputException.SPLIT_REGEX)) {
            parsedCars.add(new Car(s));
        }
        return parsedCars;
    }

    private String validated() {
        InputException inputException = new InputException();
        String validatedCarNames;
        while (true) {
            validatedCarNames = getInput();
            if (!inputException.invoke(validatedCarNames)) {
                break;
            }
        }
        return validatedCarNames;
    }

    private String getInput() {
        String carNames = scanner.nextLine();
        return carNames;
    }

}
