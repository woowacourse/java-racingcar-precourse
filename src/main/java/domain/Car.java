package domain;

import java.util.Random;

/**
 * car 클래스: 이름과 위치 움직이는 조건을 가진 클래스
 *
 * @version         1.00 2019년 04월 02일
 * @author          윤희현
 */
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private void addPosition() {
        position++;
    }

    public void goOrStop() {
        Random random = new Random();
        final int bound = 10;
        final int condition = 3;

        int randomNum = random.nextInt(bound);

        if (randomNum > condition) {
            addPosition();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
