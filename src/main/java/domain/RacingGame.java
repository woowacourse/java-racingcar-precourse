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

        Score score = new Score();
        for (int i = 0; i < times; i++) {
            score.calcScore(numberOfCar, carList);

            /* 결과 출력 */
            io.printIteration(carList);
        }

        /* 우승자 알려주기 */
        io.printWinner(score.calcWinner(carList));
    }
}
