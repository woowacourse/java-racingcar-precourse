package racingcar;

import java.util.ArrayList;

public class Game {

    /**
     * 랜덤한 숫자가 4이상이면 차 이동시키는 메서드
     * @param car
     * @return Car
     */
    public static Car moveCar(Car car) {
        return car;
    }

    /**
     * n번의 이동을 하는 게임을 시작하는 메서드
     * @param cars
     * @param num
     * @return ArrayList<Car>
     */
    public static ArrayList<Car> startGame(ArrayList<Car> cars, int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < cars.size(); j++) {
                cars.set(j, moveCar(cars.get(j)));
            }
        }
        return cars;
    }
}
