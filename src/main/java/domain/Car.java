package domain;

/**
 * Car : 자동차 클래스
 * Sort : alphabetically
 */
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public int movePosition() {
        return ++this.position;
    }
}
