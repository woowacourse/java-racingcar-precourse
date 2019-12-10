package domain;

import exception.InvalidInputException;

public class Car {

    public static final int PROCEED_BASIS_NUMBER = 4;
    public static final int CAR_NAME_LENGTH_LIMIT = 5;
    private static final String CAR_NAME_FORMAT = "%-" + Car.CAR_NAME_LENGTH_LIMIT + "s:";
    private static final String CAR_POSITION_MARK = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new InvalidInputException(InvalidInputException.NAME_OVER_LENGTH_EXCEPTION_MESSAGE);
        }
        if (name.isEmpty()) {
            throw new InvalidInputException(InvalidInputException.NAME_EMPTY_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    public void proceedOrStop(int number) {
        if (isOverNumber(number)) {
            position++;
        }
    }

    private boolean isOverNumber(int number) {
        return number >= PROCEED_BASIS_NUMBER;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String makeCurrentStatus() {
        StringBuilder result = new StringBuilder();

        result.append(String.format(CAR_NAME_FORMAT, name));
        for (int i = 0; i < position; i++) {
            result.append(CAR_POSITION_MARK);
        }

        return result.toString();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
