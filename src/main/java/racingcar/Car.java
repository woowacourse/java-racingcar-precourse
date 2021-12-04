package racingcar;

/**
 * Car 객체
 * 요구) private 변수에 set 메서드를 쓰지 말것.
 *
 * @author 장준영
 */

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward(){
        this.position++;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }
}
