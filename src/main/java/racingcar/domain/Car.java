package racingcar.domain;

/*
Car 기본 생성자를 추가할 수 없다.
name, position 변수의 접근 제어자인 private을 변경할 수 없다.
가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.
 */

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrStop() {

    }

    public int getPosition() {
        return 0;
    }
}
