package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private int position = 0;
    private String positionSign = "";
    private static List<Car> carList = new ArrayList<>();
    private static int MOVE_LIMIT_NUM = 4;
    private static int MIN_RANDOM_NUM = 0;
    private static int MAX_RANDOM_NUM = 9;

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
        if (randomNumGenerator() >= MOVE_LIMIT_NUM) {
            car.move();
        }
    }

    public static int randomNumGenerator() {
        return RandomUtils.nextInt(MIN_RANDOM_NUM,MAX_RANDOM_NUM);
    }

    public void move() {
        position += 1;
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

    public static List<String> getWinner(List<Car> carList) {
        int maxPosition = getMaxPosition(carList);
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.position == maxPosition) {
                winnerList.add(car.name);
            }
        }
        return winnerList;
    }

    public static int getMaxPosition(List<Car> carList) {
        int max = 0;

        for (Car car : carList) {
            if (car.position >= max) {
                max = car.position;
            }
        }
        return max;
    }
}
