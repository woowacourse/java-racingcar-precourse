package racinggame.view;

import racingcar.Car;
import utils.NameValidator;
import utils.RepetitionCountValidator;

import java.util.*;

import static racinggame.Constant.*;

public class InputView {

    public static List<Car> getCarList(Scanner scanner) {
        List<String> nameList = getValidNames(scanner);
        List<Car> carList = new ArrayList<>();
        for (String name : nameList) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private static List<String> getValidNames(Scanner scanner) {
        String nameSentence = scanner.nextLine();
        List<String> nameList = splitString(nameSentence);

        try {
            NameValidator.checkNameList(nameList);
            return nameList;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getValidNames(scanner);
        }
    }

    private static List<String> splitString(String nameSentence) {
        List<String> nameList = Arrays.asList(nameSentence.split(INPUT_DELIMITER, -1));
        return nameList;
    }

    public static int getRepetitionCount(Scanner scanner) {
        String count = scanner.next();

        try {
            RepetitionCountValidator.checkValidRepetitionCount(count);
            return Integer.parseInt(count);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getRepetitionCount(scanner);
        }
    }
}
