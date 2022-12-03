package racingcar;

import java.util.stream.IntStream;

public class Car {
    private final String name;
    private int position = 0;
    private NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    // 추가 기능 구현
    public String move() {
        if (isMovable()) {
            position += 1;
        }
        return createProgressMessage();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean isMovable() {
        if (numberGenerator.generate() < 4) {
            return false;
        }

        return true;
    }

    private String createProgressMessage() {
        StringBuilder message = new StringBuilder(name + " : ");
        IntStream.rangeClosed(1, position).forEach(i -> message.append("-"));
        return message.append("\n").toString();
    }
}
