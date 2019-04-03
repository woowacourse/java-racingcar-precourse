package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private void printName(){
        System.out.println(this.name + " : ");
    }

}
