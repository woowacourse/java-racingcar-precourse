package util;

import domain.Car;
import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputUtil {
    private static String INPUT_TIME_ERROR_MENT = "올바르지 않은 입력입니다. 0이상의 정수를 입력하세요";
    private static String INPUT_NAME_ERROR_MENT = "올바르지 않은 입력입니다. 각 차의 이름은 5자리 이하이고 쉼표(,)로 구분하세요";

    public static List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        List<String> carNames = getCarNames();
        carNames.forEach(name -> cars.add(new Car(name)));
        return cars;
    }

    public static int getTime() {
        String time = InputView.getTime();
        while (!checkInputTime(time)) {
            System.out.println(INPUT_TIME_ERROR_MENT);
            time = InputView.getTime();
        }
        return Integer.parseInt(time);
    }

    private static boolean checkInputTime(String time) {
        try {
            int convertedTime = Integer.parseInt(time);
            if (convertedTime < 0) {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static List<String> getCarNames() {
        String inputCarNames = InputView.getCarName();
        while (!checkInputCarNames(inputCarNames)) {
            System.out.println(INPUT_NAME_ERROR_MENT);
            inputCarNames = InputView.getCarName();
        }
        return Arrays.asList(inputCarNames.split(","));
    }

    private static boolean checkInputCarNames(String inputCarNames) {
        List<String> inputCarNameList = Arrays.asList(inputCarNames.split(","));
        for (String inputCarName : inputCarNameList) {
            if (inputCarName.length() > 5) {
                return false;
            }
        }
        return true;
    }

}
