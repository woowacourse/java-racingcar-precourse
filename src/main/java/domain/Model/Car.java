/**
 * Car.java 2019.12.07
 * <p>
 * version 1.0
 */
package domain.Model;

/**
 * Car의 이름, 현재 위치에 대한 정보를 담고 있는 클래스
 * position이 private이기 때문에 특정 조건을 만족하면
 * move 메소드를 통해 position을 1 증가 시킨다.
 *
 * @author 황성찬
 * @version 1.0 2019-12-07
 */
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
