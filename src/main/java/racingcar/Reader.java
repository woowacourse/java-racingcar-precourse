package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Reader {
    static FastReader scan = new FastReader();

    public static ArrayList<Car> inputCarName() {
        String inputText = Console.readLine();
        String[] carNames = inputText.split(",");

        ArrayList<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            // TODO --> validation 실행 //

            carList.add(new Car(carNames[i]));
        }
        return carList;
    }

    public static int inputNumberOfTry() {
        String inputText = Console.readLine();

        // TODO --> validation 실행 //

        int numberOfTry = Integer.parseInt(inputText);
        return numberOfTry;
    }
}
