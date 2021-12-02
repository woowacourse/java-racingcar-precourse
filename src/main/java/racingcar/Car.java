package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        this.position += 1;
        System.out.println("name : " + this.name + " , position : " + position);
    }
}
