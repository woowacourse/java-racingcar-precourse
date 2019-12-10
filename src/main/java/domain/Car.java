package domain;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car c) {
        return c.position - this.position;
    }

    private void validateCarName(String name) {
        if (name.startsWith(" ")) {
            throw new IllegalStateException("이름은 공백으로 시작할 수 없습니다.");
        }
    }
}