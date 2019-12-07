package domain;

import java.util.Random;

/**
 * Car 클래스는 이름과 위치를 가지는 자동차 객체이다.
 * 생성시 이름을 부여받으며, 상위 객체에서 전진 함수를 호출할 수 있다.
 *
 * @author kafka
 * @version 1.0
 */
public class Car {

    /**
     * name은 자동차 객체의 이름을 저장하는 String형 객체이다.
     */
    private final String name;

    /**
     * PASS_UNDER_LIMIT은 자동차가 전진할 때 필요한 값의 하한선이다. 이 값보다 생성한 난수값이 작다면 정지한다.
     */
    private static final int PASS_UNDER_LIMIT = 4;

    /**
     * position은 자동차의 위치를 저장하는 정수형 변수이다.
     */
    private int position = 0;

    /**
     * Car 객체의 생성자다. 이름을 설정해 준다.
     *
     * @param name : 자동차의 이름값
     */
    public Car(String name) {
        this.name = name;
    }

    /**
     * acceleateCar는 자동차의 가속을 맡는 메서드이다.
     * PASS_UNDER_LIMIT 상수값을 통해 가속 여부를 판단한다.(가속 하한선보다 아래이면 정지한다)
     */
    public int accelerateCar() {
        int randomNumber = new Random().nextInt(10);
        if (randomNumber >= PASS_UNDER_LIMIT) {
            position++;
        }
        return position;
    }

    /**
     * getPosition은 private 정수값 position을 리턴해주는 getter 메서드이다.
     *
     * @return position값을 리턴해준다.
     */
    public int getPosition() {
        return position;
    }

    /**
     * getName은 name 객체를 리턴해주는 getter 메서드이다.
     *
     * @return name값을 리턴해준다.
     */
    public String getName() {
        return name;
    }

    /**
     * printCarPosition은 경주 도중 자동차의 위치를 출력해주는 메서드이다.
     */
    private void printCarPosition() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
