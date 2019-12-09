/*
 * Car.java
 *
 * v 0.0.0
 *
 * 2019.12.06
 *
 * Copyright 2019. DunDung all rights reserved.
 */

package domain;

public class Car {
    private static final String BLANK = " ";
    private static final String COLON_AND_BOTH_BLACK = " : ";
    private static final String HYPHEN = "-";
    private static final String CONTAINS_BLANK = "자동차 이름에 공백을 포함할 수 없습니다.";
    private static final String OVER_NAME_LENGTH = "자동차 이름은 5자를 넘을 수 없습니다.";
    private static final String NAME_EMPTY = "자동차 이름은 비어있을 수 없습니다.";
    private static final int MAX_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        checkCarName(name);
        this.name = name;
    }

    public void moveAStepForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + COLON_AND_BOTH_BLACK + createHyphensByPosition();
    }

    private String createHyphensByPosition() {
        StringBuilder builder = new StringBuilder();

        for (int count = 0; count < position; count++) {
            builder.append(HYPHEN);
        }
        return builder.toString();
    }

    private void checkCarName(String name) {
        validateContainsBlank(name);
        validateNameLength(name);
        validateNameIsEmpty(name);
    }

    private void validateContainsBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(CONTAINS_BLANK);
        }
    }

    private void validateNameLength(String name) {
        if(name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(OVER_NAME_LENGTH);
        }
    }

    private void validateNameIsEmpty(String name) {
        if(name.isEmpty()) {
            throw new IllegalArgumentException(NAME_EMPTY);
        }
    }
}
