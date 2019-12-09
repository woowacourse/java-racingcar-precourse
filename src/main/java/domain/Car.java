/**
 * Car 클래스는 자동차 이름, 위치 등을 관리하는
 * 메소드를 정리해둔 클래스입니다.
 *
 * @author      양준혁
 */
package domain;

public class Car {
    private final String name;
    private int position = 0;
    public String marker = "-";

    public Car(String name) {
        this.name = name;
    }
    public String getCarName() {
        return name;
    }
    public int getCarPosition() {
        return position;
    }
    public void moveCarPosition() {
        position++;
    }
    public String printCarPosition() {
        return marker.repeat(position);
    }
}
