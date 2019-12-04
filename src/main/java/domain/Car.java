package domain;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goForward() {
        position++;
    }

    @Override
    public String toString() {
        return getName() + ": " + repeat(getPosition());
    }

    private String repeat(int times) {
        String repeatedString = "";
        for (int i = 0; i < times; i++) {
            repeatedString += "-";
        }
        return repeatedString;
    }

    @Override
    public int compareTo(Car compared) {
        return compared.getPosition() - getPosition();
    }
}
