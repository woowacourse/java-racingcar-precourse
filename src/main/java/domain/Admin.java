package domain;

import java.util.Collections;
import java.util.ArrayList;

/**
 * Admin class - 프로그램 진행에 필요한 메소드를 모아둔 클래스
 *
 * @author 김범준(ddaaac)
 * @version 1.03 2019-12-09
 */
public class Admin {
    /**
     * 전진여부 결정 시 나올 수 있는 최대 정수
     */
    protected static final int MAX_RANDOM_NUMBER = 10;

    /**
     * 전진여부 결정 시 threshold 값 이상이면 전진
     */
    protected static final int MIN_THRESHOLD = 4;

    /**
     * Car 객체를 저장하는 Array
     */
    private Car[] cars;

    /**
     * 입출력을 담당하는 클래스
     */
    private IO racingCarIO = new IO();

    /**
     * 이름을 입력받고 Car 객체를 생성하는 메소드
     */
    public void makeCars() {
        /* input이 유효할 때까지 이름을 입력받고, 입력받은 String을 기준으로 Car 객체 생성 */

        String[] carNames = racingCarIO.getCarNamesUntilValid();

        cars = new Car[carNames.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = makeCar(carNames[i]);
        }
    }

    /**
     * 움직일 횟수를 입력받고 전진시키는 과정을 출력하는 메소드
     */
    public void moveCars() {
        /* input이 유효할 때까지 숫자를 입력받고, 입력받은 숫자만큼 각 Car 객체를 이동시키고, 그 과정을 출력함 */

        int numOfMoving = racingCarIO.getNumOfMovingUntilValid();

        for (int i = 0; i < numOfMoving; i++) {
            carsMoveForward();
            printPosition();
        }
    }

    /**
     * 우승자를 출력하는 메소드
     */
    public void printWinner() {
        /* 각 자동차의 position 변수를 확인해서 그 값이 가장 큰 자동차들의 이름을 출력 */

        ArrayList<Integer> carsPosition = getCarsPosition();
        ArrayList<String> winnersList = getWinnersList(carsPosition);
        racingCarIO.printWinner(winnersList);
    }

    /**
     * Car 객체를 생성하여 반환하는 메소드
     *
     * @param name Car 객체의 이름
     * @return 입력받은 이름으로 생성된 Car 객체
     */
    private Car makeCar(String name) {
        return new Car(name);
    }

    /**
     * 자동차들을 전진시키는 메소드
     */
    private void carsMoveForward() {
        for (int i = 0; i < cars.length; i++) {
            cars[i].moveForward();
        }
    }

    /**
     * 자동차의 전진과정을 출력하는 메소드
     */
    private void printPosition() {
        racingCarIO.printPosition(cars);
    }

    /**
     * 자동차들의 position 을 구하는 메소드
     *
     * return 자동차들의 position이 저장된 ArrayList
     */
    private ArrayList<Integer> getCarsPosition() {
        ArrayList<Integer> carsPosition = new ArrayList<>();

        for (int i = 0; i < cars.length; i++) {
            carsPosition.add(cars[i].getPosition());
        }
        return carsPosition;
    }

    /**
     * 우승 자동차들의 이름들을 구하는 메소드
     *
     * @param carsPosition 자동차들의 position이 담긴 ArrayList
     * @return 포지션이 가장 큰 자동차들의 이름이 담긴 ArrayList
     */
    private ArrayList<String> getWinnersList(ArrayList<Integer> carsPosition) {
        ArrayList<String> winnersList = new ArrayList<>();
        int maxPosition = Collections.max(carsPosition);

        for (int i = 0; i < carsPosition.size(); i++) {
            if (carsPosition.get(i) == maxPosition) {
                winnersList.add(cars[i].getName());
            }
        }
        return winnersList;
    }
}
