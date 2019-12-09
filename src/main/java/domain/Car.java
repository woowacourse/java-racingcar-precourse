package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) throws IllegalArgumentException {
        name = name.trim();
        validateLength(name);
        validateEmpty(name);
        this.name = name;
    }

    private static void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자이하만 가능합니다.");
        }
    }

    private static void validateEmpty(String name) {
        if (name.length() == 0) {
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
        return this.position==position;
    }
}