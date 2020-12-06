package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAMES_PHRASE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    private static final String INPUT_TRIAL_NUMBER_PHRASE = "시도할 횟수는 몇 회인가요\n";

    private Scanner scanner;
    private InputValidator inputValidator;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
        this.inputValidator = new InputValidator();
    }

    public List<Car> getCarNames() {
        System.out.print(INPUT_CAR_NAMES_PHRASE);
        return parseCarNames(validatedCarNames());
    }

    public int getTrialNumber() {
        System.out.print(INPUT_TRIAL_NUMBER_PHRASE);
        return validatedTrialNumber();
    }

    private List<Car> parseCarNames(String validatedInput) {
        List<Car> parsedCars = new ArrayList<>();
        for (String s : validatedInput.split(InputValidator.SPLIT_REGEX)) {
            parsedCars.add(new Car(s));
        }
        return parsedCars;
    }

    private String validatedCarNames() {
        String validatedCarNames;
        while (true) {
            validatedCarNames = getInput();
            if (!inputValidator.invokeRegardingToCarNames(validatedCarNames)) {
                break;
            }
        }
        return validatedCarNames;
    }

    private String getInput() {
        String carNamesInput = scanner.nextLine();
        return carNamesInput;
    }

    private int validatedTrialNumber() {
        String validatedTrialNumber;
        while (true) {
            validatedTrialNumber = getInput();
            if (!inputValidator.invokeRegardingToTrialNumber(validatedTrialNumber)) {
                break;
            }
        }
        return Integer.parseInt(validatedTrialNumber);
    }

}
