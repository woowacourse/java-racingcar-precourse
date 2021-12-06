package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public void moveForward() {
        position += 1;
    }

    public void moveResult() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
