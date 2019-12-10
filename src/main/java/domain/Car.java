package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
    	this.position = position;
    }
    public String getName() {
    	return this.name;
    }
    public int getPosition() {
    	return this.position;
    }
}
