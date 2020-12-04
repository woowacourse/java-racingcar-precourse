package racingcar;

public class Car implements Comparable<Car>{
    private final String name;
    private int position = 0;

    public Car(final String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void move(){
        position += 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car c) {
        return c.position - this.position;
    }
}
