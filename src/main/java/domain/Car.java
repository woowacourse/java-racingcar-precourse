package domain;

import java.util.Random;
import java.util.stream.IntStream;

public class Car implements Movable {
    public static final int MAX_RAND = 10;
    public static final int MOVE = 4;

    private final String name;

    public int getPosition() {
        return position;
    }

    private int position = 0;
    private final Random rand;

    private static final String CHAR_POSITION = "-";

    public Car(String name, Random rand) {
        this.name = name;
        this.rand = rand;
    }

    // 추가 기능 구현
    @Override
    public void tryMove() {
        if (canMove(this.rand.nextInt(MAX_RAND))) {
            position++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + ": ");

        IntStream.range(0, this.position).forEach((i) -> sb.append(CHAR_POSITION));

        return sb.toString();
    }

    private Boolean canMove(int v) {
        return MOVE <= v;
    }
}
