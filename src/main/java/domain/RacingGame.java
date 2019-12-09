package domain;

import java.util.ArrayList;

public class RacingGame {
    public static void main(String[] args) {
        UserIO io = new UserIO();

        /* 이름 입력 */
        String[] names = io.getName();
        int numberOfCar = names.length;

        /* 횟수 입력 */
        int times = io.getTimes();

        /* 차량 목록 인스턴스화 */
        CarList carList = new CarList(names);
        RandomNumberGenerator prng = new RandomNumberGenerator(numberOfCar);
        for (int i = 0; i < times; i++) {
            ArrayList<Boolean> direction = prng.goNoGo();
            for (int j = 0; j < numberOfCar; j++) {
                int previousPosition = carList.car.get(j).getPosition();
                if (direction.get(j)) {
                    carList.car.get(j).setPosition(previousPosition + 1);
                }
            }
            /* 결과 출력 */
            carList.printCarList();
        }

        /* 우승자 알려주기 */


    }
}
