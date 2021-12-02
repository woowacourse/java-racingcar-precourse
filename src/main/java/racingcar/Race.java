package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Race {
    private static ArrayList<Car> cars = new ArrayList<>();

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
}
