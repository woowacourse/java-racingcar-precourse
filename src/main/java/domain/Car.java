package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void go(){
        this.position += 1;
        return;
    }

    public void stop(){
        return;
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

}
