package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void moveForward(){
        this.position ++;
    }

    public void printProgress(){
        System.out.print(name + " : ");
        for(int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
