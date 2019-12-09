/**
 * GameFunction 클래스는 기본적으로 게임의 진행에 관련된
 * 메소드를 정리해둔 클래스입니다.
 *
 * @author      양준혁
 */
package domain;

import java.util.ArrayList;

public class GameFunction {
    public static int randomNumber;
    public static int maxCarPosition;
    public static ArrayList winnerList = new ArrayList();

    public static void startRacingGame(Car[] cars, int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            moveCars(cars);
            printRacingResult(cars);
        }
        findMaxCarPosition(cars);
        makeWinnerList(cars);
        printWinner(cars);
    }
    public static void moveCars(Car[] cars) {
        for (Car car : cars) {
            if (checkRandomNumber()) {
                car.moveCarPosition();
            }
        }
    }
    public static boolean checkRandomNumber() {
        randomNumber = (int) (Math.random() * 10);
        return randomNumber >= 4;
    }
    public static void printRacingResult(Car[] cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.printf("%s : %s \n", car.getCarName(), car.printCarPosition());
        }
    }
    public static void findMaxCarPosition(Car[] cars) {
        maxCarPosition = 0;
        for (Car car : cars) {
            if (car.getCarPosition() > maxCarPosition) {
                maxCarPosition = car.getCarPosition();
            }
        }
    }
    public static void makeWinnerList(Car[] cars) {
        for (Car car : cars) {
            if (car.getCarPosition() == maxCarPosition) {
                winnerList.add(car.getCarName());
            }
        }
    }
    public static void printWinner(Car[] cars) {
        System.out.printf("%s가 최종 우승했습니다.",String.join(", ", winnerList));
    }
}
