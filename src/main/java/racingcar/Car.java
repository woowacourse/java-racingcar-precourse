package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward() {
        this.position++;
    }

    public void displayPosition() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.position; i++)
            System.out.print("-");
        System.out.println();
    }
}
