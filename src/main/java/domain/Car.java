package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    public void moveCar(int randomCount) {
        if ( randomCount >= 4) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void printRaceSituation() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}