package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name.trim();
    }

    // 추가 기능 구현
    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {
        this.position++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name + " : ");
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
