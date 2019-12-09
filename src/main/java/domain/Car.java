package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return this.name;
    }

    public int currPosition() {
        return this.position;
    }

    public void addPosition() {
        this.position += 1;
    }
}