package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    private static final int CAN_MOVE_NUM = 4;

    private final String name;
    private int position;
    public static int maxPosition = 0;
    public static List<Car> carList = new ArrayList<>();

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForward() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
        if (randomNumber >= CAN_MOVE_NUM) {
            position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }

    public void addCarList(Car car) {
        carList.add(car);
    }

    public static void getWinner() {
        getMaxPosition();
        getWinnerList();
        OutputView.printWinner(getWinnerList());
    }

    private static List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.position == maxPosition) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private static int getMaxPosition() {
        for (Car car : carList) {
            if (car.position > maxPosition) {
                maxPosition = car.position;
            }
        }
        return maxPosition;
    }

    public static void moveCar() {
        for (Car car : carList) {
            car.moveForward();
        }
    }
    // 추가 기능 구현
}