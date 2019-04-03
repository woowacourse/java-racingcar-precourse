package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Race {
    ArrayList<Car> cars = new ArrayList<>();

    public void setCarNames() {
        String userInputString;
        ArrayList<String> carNames = new ArrayList<>();

        while (carNames.isEmpty()) {
            userInputString = getInputCarNames();
            carNames = validateUserInput(userInputString);
        }

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    private String getInputCarNames() {
        Scanner scan = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scan.next();
    }

    private ArrayList<String> validateUserInput(String inputString) {
        ArrayList<String> parsedNames = parseInputString(inputString);

        for (String names : parsedNames) {
            if (names.length() > 5) {
                return new ArrayList<>();
            }
        }

        return parsedNames;
    }

    private ArrayList<String> parseInputString(String inputString) {
        return new ArrayList<> (Arrays.asList(inputString.split(",")));
    }
}
