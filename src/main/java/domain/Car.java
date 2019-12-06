package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void drive() {
        this.position ++;
    }

    public String getName() {
        return this.name;
    }

   public int getPosition() {
        return this.position;
    }

    public void printDistance() {
        print(this.name+" : ");
        for (int i = 0; i < this.position; i ++) {
            print("-");
        }
        print("\n");
    }

    private void print(String string) {
        System.out.print(string);
    }

}
