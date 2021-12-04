package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import static racingcar.Application.carList;
import static racingcar.Application.numberOfTry;

public class Generator {

    public static void inputCarName() {
        while (true){
            try {
                String inputText = Console.readLine();
                String[] carNames = inputText.split(",");

                InputValidator.validateCarNames(carNames);
                generateCarList(carNames);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }
        }
    }

    public static void inputNumberOfTry() {
        while (true) {
            try {
                String inputText = Console.readLine();

                InputValidator.validateNumberOfTry(inputText);
                numberOfTry = Integer.parseInt(inputText);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }
        }
    }

    public static void generateCarList(String[] carNames) {
        carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i]));
        }
    }
}
