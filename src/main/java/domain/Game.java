package domain;
import java.util.*;

public class Game {
    public static void gameStart(String carName, int count) {
        ArrayList<Car> carList = inputSlice(carName);

        racingSimulation(carList, count);
    }

    public static ArrayList<Car> inputSlice(String carName) {
        ArrayList<Car> carList = new ArrayList<Car>();
        String[] carNames = carName.split(",");

        for(int i = 0; i < carNames.length; i++) {
            Car temp = new Car(carNames[i]);
            carList.add(temp);
        }
        return carList;
    }

    public static void racingSimulation(ArrayList<Car> carList, int count) {

    }
}