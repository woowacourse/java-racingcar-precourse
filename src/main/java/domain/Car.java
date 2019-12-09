package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) throws IllegalArgumentException {
        validateCarName(name);
        this.name = name;
    }

    private static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void proceed() {
        this.position++;
    }

    public void printPosition() {
        System.out.print(this.name + " : " + displayPosition(this.position));
    }

    private String displayPosition(int position) {
        StringBuilder displayForPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            displayForPosition.append("-");
        }
        return displayForPosition.toString();
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isSamePosition(int position) {
        return this.position==position;
    }
}