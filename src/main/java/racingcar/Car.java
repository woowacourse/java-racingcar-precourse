package racingcar;

import utils.RandomUtils;

/**
 * Car 객체를 다루는 클래스
 *
 * @author 483759@naver.com / 윤이진
 * @version 1.0 2020/12/05
 */
public class Car {

    private final String name;
    private int position = 0;
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int FORWARD_BEYOND = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    /* 랜덤 난수를 발생시켜 전진 여부를 결정하는 메소드 */
    public boolean determineMove() {
        int random = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
        if (random >= FORWARD_BEYOND) {
            return true;
        }
        return false;
    }

    public void movePosition() {
        if (determineMove()) {
            this.position++;
        }
    }

    /* 현재 위치만큼 -을 출력하는 메소드 */
    public void printPosition() {
        for (int i = 0; i < position; i++) {
            System.out.printf("-");
        }
    }
}
