/*
 * AppMain
 *
 * version 1.0
 *
 * 2019/04/02
 */

import domain.Car;
import domain.Racing;

import java.util.List;

/**
 * 자동차 경주 게임을 진행할 수 있는 main 클래스
 *
 * @author 김성훈
 * @version 1.0 2019/04/02  main 클래스 생성
 */
public class AppMain {
    public static List<Car> cars;
    public static String[] carNames;
    public static int round;
    public static String winners;

    public static void main(String[] args) {
        Racing racing = new Racing();

        carNames = racing.inputCarName();
        round = racing.inputRound();
        cars = racing.createCars(carNames);

        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            racing.moveAllCarsOnRace(cars);
        }

        winners = racing.calcWinners(cars);
        racing.printWinners(winners);
    }
}
