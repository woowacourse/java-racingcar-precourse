package domain;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * IO class - 프로그램의 실제 입출력을 담당하는 Class
 *
 * @author 김범준(ddaaac)
 * @version 1.03 2019-12-09
 */
public class IO {
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
     * 입력한 이름이 유효할때까지 입력을 받는 메소드
     *
     * @return Car 객체 각각 이름이 담긴 String Array
     */
    protected String[] getCarNamesUntilValid() {
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
     * 입력한 숫자가 유효할때까지 입력을 받는 메소드
     *
     * @return 움직일 횟수
     */
    protected int getNumOfMovingUntilValid() {
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
     * 자동차의 전진과정을 출력하는 메소드
     *
     * @param cars Car 객체 배열
     */
    protected void printPosition(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            cars[i].printPosition();
        }
        System.out.println();
    }

    /**
     * 자동차의 전진과정을 출력하는 메소드
     *
     * @param winnersList 우승자 리스트
     */
    protected void printWinner(ArrayList<String> winnersList) {
        String winnersName = String.join(", ", winnersList);

        System.out.println(winnersName + "이/가 최종 우승했습니다.");
    }

    /**
     * 쉼표로 구분된 차 이름을 입력받아 반환하는 메소드
     *
     * @return 차 이름들이 담긴 String Array, 유효하지 읺은 input에 대하여 INVALID_CAR_NAME
     */
    private String[] getCarNames() {
        String input;
        String carNameValidPattern = "([a-zA-Z][a-zA-Z0-9]{0,4}(,|$))+";

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = scan.nextLine();
        if (!input.matches(carNameValidPattern)) {
            return INVALID_CAR_NAME;
        }
        return input.split(",");
    }

    /**
     * 자동차를 최대 몇 번 이동시킬지 입력받는 메소드
     *
     * @return 움직일 횟수, 유효하지 않은 input에 대하여 INVALID_NUMBER
     */
    private int getNumOfMoving() {
        String input;
        int numOfMoving;
        String numberValidPattern = "^[1-9][0-9]*";

        System.out.println("시도할 횟수는 몇회인가요?");
        input = scan.nextLine();
        if (!input.matches(numberValidPattern)) {
            return INVALID_NUMBER;
        }
        numOfMoving = Integer.parseInt(input);
        return numOfMoving;
    }
}
