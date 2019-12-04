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
        return this.position;
    }

    public void goForward() {
        this.position++;
    }

    @Override
    public String toString() {
        return getName() + ": " + repeat(getPosition());
    }

    private String repeat(int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += "-";
        }
        return result;
    }

    @Override
    public int compareTo(Car compared) {
        return compared.getPosition() - getPosition();
    }
}
