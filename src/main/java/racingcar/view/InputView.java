package racingcar.view;

import racingcar.Car;
import utils.NameValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static racingcar.Constant.*;

public class InputView {

    public static List<Car> getCarList(Scanner scanner) {
        String nameSentence = scanner.next();
        List<String> nameList = getValidNames(nameSentence);

        List<Car> carList = new ArrayList<>();
        return new ArrayList<>();
    }

    private static List<String> getValidNames(String nameSentence) {
        List<String> nameList = splitString(nameSentence);
        return nameList;
    }

    private static List<String> splitString(String nameSentence) {
        List<String> nameList = Arrays.asList(nameSentence.split(INPUT_DELIMITER));
        return nameList;
    }

    public static int getRepetitionCount() {

        return 0;
    }
}
