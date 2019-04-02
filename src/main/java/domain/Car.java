/*
 * Car
 *
 * version 1.0
 *
 * 2019/04/02
 *
 */

package domain;

/**
 * 자동차를 만들고 이동할 수 있는 클래스
 *
 * @author 김성훈
 * @version 1.0 2019/04/02  자동차의 이동 여부를 결정하는 난수 발생 메소드 구현 / 난수값을 확인 후 자동차 이동 처리
 */
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int makeRandomNumber() {
        return (int)(Math.random() * 10);
    }

    public void moveCar(int randomNumber) {
        if(4 <= randomNumber && randomNumber <= 9) {
            ++this.position;
        }
    }
}
