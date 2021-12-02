package racingcar;

public class Car {
    private final String name;
    private int position = 0;
    private String moveStatus = "";

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        this.position += 1;
        this.moveStatus += "-";
    }

    public void printStatus() {
        System.out.println(name + " : " + moveStatus);
    }
}
