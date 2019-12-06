package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void March() {
        if (isOkayToMarch()) {
            position++;
        }
    }
    private boolean isOkayToMarch() {
        double randomInt = Math.floor(Math.random() * 10);
        return randomInt >= 4.0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
