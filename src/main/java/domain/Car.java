/**
 * Car 클래스는 외부 조건에 따라 이동할 수 있는 자동차를 표현합니다.
 */

package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void moveCar(boolean command) {
        if (command) {
            position += 1;
        }
    }

}