package racingcar.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.message.ErrorMessage.CAR_NAME_TOO_LONG;
import static racingcar.message.Message.*;
import static racingcar.util.Number.NAME_MIN_LENGTH;
import static racingcar.util.Number.STANDARD_NUMBER;

public class Car {
    private final int maxNameSize = 5;
    private final String name;
    private int position = 0;


    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > maxNameSize || name.length() < NAME_MIN_LENGTH.getNumber()) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG.getMessage());
        }
    }

    // 추가 기능 구현
    public void move(int moveInput) {
        if (moveInput >= STANDARD_NUMBER.getNumber()) position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(name);
        appendPosition(print);
        return print.toString();
    }

    private void appendPosition(StringBuilder print) {
        print.append(INFIX.getMessage());
        print.append(IntStream.range(0, position).mapToObj(i -> POSITION.getMessage()).collect(Collectors.joining()));
    }

    public String getWinnerName(int maxPosition) {
        if (maxPosition == position) return name;
        return LOSER.getMessage();
    }
}
