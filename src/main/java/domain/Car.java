package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public int currPosition() {
        return position;
    }

    public void addPosition() {
        position += 1;
    }
}