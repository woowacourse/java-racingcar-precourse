package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void boostOrStop() {
        int dice = (int)Math.floor(Math.random() * 10);

        if (dice >= 4) {
            this.position++;
        }
    }

}
