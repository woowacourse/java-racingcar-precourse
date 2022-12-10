package racingcar.domain;

import racingcar.util.Number;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.message.ErrorMessage.CAR_NAME_TOO_LONG;
import static racingcar.message.Message.INFIX;
import static racingcar.message.Message.POSITION;

public class Car {
    private final int maxNameSize = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > maxNameSize) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG.getMessage());
        }
    }

    // 추가 기능 구현
    public void move(int moveInput) {
        if (moveInput >= Number.STANDARD_NUMBER.getNumber()) position++;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(name);
        print.append(INFIX.getMessage());
        appendPosition(print);
        return print.toString();
    }

    private void appendPosition(StringBuilder print) {
        print.append(IntStream.range(0, position).mapToObj(i -> POSITION.getMessage()).collect(Collectors.joining()));
    }
}
