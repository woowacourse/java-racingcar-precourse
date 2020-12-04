package racingcar;

public class Car {

    private static final int MAXIMUM_NAME_RANGE = 5;
    private static final int MINIMUM_NAME_RANGE = 1;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameRange(name);
        name = trimName(name);
        this.name = name;
    }

    private String trimName(String name) {
        return name.trim();
    }

    private void validateNameRange(String name) {
        if (MAXIMUM_NAME_RANGE < name.length()) {
            throw new IllegalArgumentException();
        }
        if (MINIMUM_NAME_RANGE > name.length()) {
            throw new IllegalArgumentException();
        }
    }

    public void moveForward() {
        position += 1;
    }

    public void printStatus() {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < position; i++) {
            progress.append("-");
        }

        System.out.println(name + " : " + progress);
    }

    @Override
    public boolean equals(Object obj) {
        Car car;
        if (obj instanceof Car) {
            car = (Car) obj;
        } else {
            return false;
        }
        return this.name.equals(car.name) && this.position == car.position;
    }

    @Override
    public String toString() {
        return name;
    }
}
