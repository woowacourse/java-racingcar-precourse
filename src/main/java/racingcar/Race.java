package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Race {
    private static ArrayList<Car> cars = new ArrayList<>();
    private static int moveCount;
    public static String getUserInput() {
        return Console.readLine();
    }

    public static void getCarByName() {
        String userInput = getUserInput();
        String[] carNames = userInput.split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public static void getMoveCount() {
        String userInput = getUserInput();
        moveCount = Integer.parseInt(userInput);
    }
}
