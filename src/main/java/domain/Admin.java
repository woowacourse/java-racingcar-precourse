package domain;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Admin class - 프로그램 진행에 필요한 메소드를 모아둔 클래스
 *
 * @author 김범준(ddaaac)
 * @version 1.02 2019-12-06
 */
public class Admin {
    /**
     * 전진여부 결정 시 나올 수 있는 최대 정수
     */
    protected static final int MAX_RANDOM_NUMBER = 9;

    /**
     * 전진여부 결정 시 threshold 값 이상이면 전진
     */
    protected static final int MIN_THRESHOLD = 4;

    /**
     * 값을 입력받기 위한 Scanner class
     */
    private static final Scanner scan = new Scanner(System.in);

    /**
     * 유효하지 않은 자동차 이름을 나타내는 클래스 변수
     */
    private static final String[] INVALID_CAR_NAME = null;

    /**
     * 유효하지 않은 숫자를 나타내는 클래스 변수
     */
    private static final int INVALID_NUMBER = -1;

    /**
     * Car 객체를 저장하는 Array
     */
    private Car[] cars;

    /**
     * 이름을 입력받고 Car 객체를 생성하는 메소드
     */
    public void makeCars() {
        /* input이 유효할 때까지 이름을 입력받고, 입력받은 String을 기준으로 Car 객체 생성 */

        String[] carNames = getCarNamesUntilValid();

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

        int numOfMoving = getNumOfMovingUntilValid();

        for (int i = 0; i < numOfMoving; i++) {
            carsMoveForward();
            printPosition();
            System.out.println();
        }
    }

    /**
     * 우승자를 출력하는 메소드
     */
    public void printWinner() {
        /* 각 자동차의 position 변수를 확인해서 그 값이 가장 큰 자동차들의 이름을 출력 */

        ArrayList<Integer> carsPosition = getCarsPosition();
        ArrayList<String> winnersList = getWinnersList(carsPosition);
        String winnersName = String.join(", ", winnersList);

        System.out.println(winnersName + "이/가 최종 우승했습니다.");
    }

    /**
     * 입력한 이름이 유효할때까지 입력을 받는 메소드
     *
     * @return Car 객체 각각 이름이 담긴 String Array
     */
    private String[] getCarNamesUntilValid() {
        String[] carNames;

        while (true) {
            carNames = getCarNames();
            if (carNames == INVALID_CAR_NAME) {
                System.out.println("다시 입력해주세요.");
                continue;
            }
            return carNames;
        }
    }

    /**
     * 쉼표로 구분된 차 이름을 입력받아 반환하는 메소드
     *
     * @return 차 이름들이 담긴 String Array, 유효하지 읺은 input에 대하여 INVALID_CAR_NAME
     */
    private String[] getCarNames() {
        String input;
        String carNameValidPattern = "([a-zA-Z][a-zA-Z0-9]{0,4}(,|$))+";         // 유효한 패턴은 1~5 글자의 영문 알파벳, 숫자를 의미

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = scan.nextLine();
        if (!input.matches(carNameValidPattern)) {
            return INVALID_CAR_NAME;
        }
        return input.split(",");
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
     * 입력한 숫자가 유효할때까지 입력을 받는 메소드
     *
     * @return 움직일 횟수
     */
    private int getNumOfMovingUntilValid() {
        int numOfMoving;

        while (true) {
            numOfMoving = getNumOfMoving();
            if (numOfMoving == INVALID_NUMBER) {
                System.out.println("다시 입력해주세요.");
                continue;
            }
            return numOfMoving;
        }
    }

    /**
     * 자동차를 최대 몇 번 이동시킬지 입력받는 메소드
     *
     * @return 움직일 횟수, 유효하지 않은 input에 대하여 INVALID_NUMBER
     */
    private int getNumOfMoving() {
        String input;
        int numOfMoving;
        String numberValidPattern = "^[1-9][0-9]*";       // 한자리 이상의 숫자를 의미

        System.out.println("시도할 횟수는 몇회인가요?");
        input = scan.nextLine();
        if (!input.matches(numberValidPattern)) {
            return INVALID_NUMBER;
        }
        numOfMoving = Integer.parseInt(input);
        return numOfMoving;
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
        for (int i = 0; i < cars.length; i++) {
            cars[i].printPosition();
        }
        System.out.println();
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
