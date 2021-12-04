package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import static racingcar.Application.carList;
import static racingcar.Application.numberOfTry;

public class Generator {

    public static ArrayList<Car> inputCarName() {
        String inputText = Console.readLine();
        String[] carNames = inputText.split(",");

        carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            // TODO --> validation 실행 //

            carList.add(new Car(carNames[i]));
        }
        return carList;
    }

    public static void inputNumberOfTry() {
        String inputText = Console.readLine();

        // TODO --> validation 실행 //

        numberOfTry = Integer.parseInt(inputText);
    }
}
