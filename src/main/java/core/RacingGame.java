/**
 * 우아한테크코스 프리코스 2주차 미션
 * 자동차 경주 게임
 *
 * @author JiHoon Kim
 * @version 1.0
 */

package core;

import domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private int round;                  /* 게임에서 시도 횟수를 저장하는 변수 */
    private List<Car> carList;          /* 자동차들의 객체를 저장하는 ArrayList */
    private Scanner scanner;
    private Random random;

    public RacingGame() {
        scanner = new Scanner(System.in);
        carList = new ArrayList<>();
        random = new Random();
    }

    /**
     * 자동차의 이름과 시도 횟수를 입력받는 메소드
     *
     * @return 정상적인 값을 입력받으면 True, 예외처리를 통해 비정상적인 값이면 False
     */
    private boolean init() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String nameInput = scanner.next();
        scanner.nextLine();
        String[] nameInputList = nameInput.split(",");
        for (String name : nameInputList) {
            Car car = new Car(name);
            carList.add(car);
        }
        System.out.println("시도할 횟수는 몇회인가요?");
        round = scanner.nextInt();
        System.out.println();

        return true;
    }

    /**
     * 한 라운드에 대하여 자동차의 전진 처리와 현재 위치 출력을 하는 메소드
     */
    private void playRounds() {
        for (Car car : carList) {
            if (random.nextInt(10) >= 4)
                car.goForward();
            car.printPosition();
        }
        System.out.println();
    }

    private void printWinner() {
        String winnerName = "";
        int winnerPosition = 0;

        for (Car car : carList) {
            if (car.getPosition() > winnerPosition) {
                winnerName = car.getName();
                winnerPosition = car.getPosition();
            } else if (car.getPosition() == winnerPosition)
                winnerName += ("," + car.getName());
        }

        System.out.println(winnerName + "가 최종 우승했습니다!");
    }

    private void finish() {
        scanner.close();
    }

    /**
     * 이 메소드를 실행하면 전체 게임 과정을 진행하게 됨
     *
     * @return 정상적으로 게임이 종료되면 True, 비정상적으로 종료되었을 경우 False
     */
    public boolean progressGame() {
        if (!init())
            return false;

        System.out.println("실행결과");
        System.out.println();
        for (int i = 0; i < round; i++)
            playRounds();

        printWinner();

        finish();

        return true;
    }
}
