package domain;

public class Car {
    private static final int MAX_OF_NAME_LENGTH = 5;
    private static final int EMPTY_NAME_LENGTH = 0;

    private final String name;
    private int position = 0;

    public Car(String name) throws IllegalArgumentException {
        name = name.trim();
        validateLength(name);
        validateEmpty(name);
        this.name = name;
    }

    private static void validateLength(String name) {
        if (name.length() > MAX_OF_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자이하만 가능합니다.");
        }
    }

    private static void validateEmpty(String name) {
        if (name.length() == EMPTY_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 공백일 수 없습니다.");
        }
    }

    public void proceed() {
        this.position++;
    }

    public void printPosition() {
        System.out.printf("%-5s : %s%n", this.name, displayPosition(this.position));
    }

    private String displayPosition(int position) {
        StringBuilder displayForPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            displayForPosition.append("-");
        }
        return displayForPosition.toString();
    }

    String getName() {
        return this.name;
    }

    int getPosition() {
        return this.position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }
}