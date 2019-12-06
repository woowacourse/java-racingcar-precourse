package domain;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomInteger = makeRandomInt();
        if (randomInteger >= 4) {
            position++;
        }
    }

    private int makeRandomInt() {
        double randomNumber = Math.random();

        return (int) (randomNumber * 10);
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.getPosition();
    }

    // 추가 기능 구현
}
