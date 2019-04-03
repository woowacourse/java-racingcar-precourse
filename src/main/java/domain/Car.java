package domain;

public class Car {
    private static final int RANDOM_SCOPE = 10;
    private static final int POINT_TO_ACCELERATE = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void accelerate() {
        int rand = (int) (Math.random() * RANDOM_SCOPE);
        if (rand >= POINT_TO_ACCELERATE) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
