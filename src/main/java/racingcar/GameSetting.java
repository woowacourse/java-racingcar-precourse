package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class GameSetting {
    final static String inputCarNamePrint = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final static String inputTrackLengthPrint = "시도할 회수는 몇회인가요?";

    public static ArrayList<Car> carList(Scanner scanner) {
        ArrayList<Car> result = new ArrayList<Car>();
        String inputString = inputAndOutput.inputString(scanner, inputCarNamePrint);
        String[] carNameList = carNameList(inputString);
        for (int i = 0; i < carNameList.length; i++) {
            result.add(new Car(carNameList[i]));
        }
        return result;
    }

    static String[] carNameList(String inputString) {
        return inputString.split(",");
    }

    static int trackLength(Scanner scanner) {
        return inputAndOutput.inputInt(scanner, inputTrackLengthPrint);
    }
}
