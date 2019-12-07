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

    public void printName(){
        System.out.print(this.name + ":");
    }

    public void printPosition(){
        System.out.print(this.position + "\n");
    }

}
