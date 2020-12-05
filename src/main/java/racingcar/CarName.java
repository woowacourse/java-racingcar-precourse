package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class CarName {
    final static String inputCarNamePrint = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static ArrayList<Car> carList(Scanner scanner) {
        ArrayList<Car> result = new ArrayList<Car>();
        String inputString = inputAndOutput.inputString(scanner, inputCarNamePrint);
        carNameList(inputString);
        return result;
    }

    static String[] carNameList(String inputString){
        return inputString.split(",");
    }
}
