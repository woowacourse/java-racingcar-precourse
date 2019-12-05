package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void progressCar() {
    	this.position++;
    }
}
