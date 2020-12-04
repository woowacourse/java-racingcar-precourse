package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private int position = 0;
    private String positionSign = "";
    private static List<Car> carList = new ArrayList<>();

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static List<Car> makeCarList(String userInput) {
        List<String> userList = CheckValidation.stringToList(userInput);
        for (String car : userList) {
            carList.add(new Car(car, 0));
        }
        return carList;
    }

    public static void setPosition(Car car) {
        moveOrStop(car);
    }

    public static void moveOrStop(Car car) {
        if (RandomUtils.nextInt(0,9) >= 4) {
            car.move();
        }
    }

    public void move() {
        position++;
    }

    public static void displayPosition(List<Car> cars) {
        for (Car car : cars) {
            car.changePositionsign(car);
            System.out.println(car.name + " : " + car.positionSign);
        }
        System.out.println();
    }

    public String changePositionsign(Car car) {
        for (int i = 0; i < car.position; i++) {
            positionSign += "-";
        }
        return positionSign;
    }



}
