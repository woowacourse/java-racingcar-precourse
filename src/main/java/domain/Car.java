package domain;

public class Car {
    private static final int ENOUGH_LIMIT = 4;
    private final Name name;
    private int position = 0;

    private Car(Name name) {
        this.name = name;
    }

    public static Car generateCar(String name) {
        return new Car(new Name(name));
    }

    void move(Integer randomInput) {
        if (enough(randomInput)) {
            this.position++;
        }
    }

    private Boolean enough(Integer randomInput) {
        return randomInput >= ENOUGH_LIMIT;
    }

    public int getPosition() {
        return position;
    }

    public String getCarOriginName() {
        return name.getName();
    }

    public boolean isMatchPosition(int otherPosition) {
        return this.position == otherPosition;
    }
}
