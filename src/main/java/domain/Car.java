package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void drive() {
        position ++;
    }

   public int getPosition() {
        return position;
    }

    public void printDistance() {
        System.out.print(name+" : ");
        for (int i = 0; i < position; i ++) {
            System.out.print("-");
        }
    }

}
