import static java.lang.Math.random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    boolean movingForward() {
        int randomValue = (int) (Math.random() * 10);
        if (randomValue >= 4) {
            this.position++;
            return true;
        }
        return false;
    }
}
