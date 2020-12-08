package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    String position() {
        return name + " : " + "-".repeat(position) + "\n";
    }

    String getName() {
        return name;
    }

    void move() {
        this.position += 1;
    }

    boolean isMaxPosition(int lastMaxPosition) {
        return this.position > lastMaxPosition;
    }

    boolean isWinner(int winnerDistance) {
        return position == winnerDistance;
    }
}
