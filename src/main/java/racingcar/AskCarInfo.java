package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AskCarInfo {

    public static ArrayList<String> askCarInfo(Scanner scanner) {
        String userInput = null;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        if (scanner.hasNext() || userInput == null) {
            userInput = scanner.nextLine();
            System.out.println(userInput);
        }
        return parseCar(userInput);
    }

    public static ArrayList<String> parseCar(String userInput) {

        ArrayList<String> carList = new ArrayList<String>(Arrays.asList(userInput.split(",")));
        for (int i = 0; i< carList.size(); i++) {
            System.out.println(("size" + carList.get(i).length()));
            System.out.println(carList.get(i));
        }
        return carList;
    }
}
