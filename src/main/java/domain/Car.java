package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void doRacing() {
        int randomNum = (int) (Math.random() * 9);
        if (randomNum >= 4) {
            this.position++;
        }
    }

    public void printPosition() {
        System.out.println(this.name + " : ");
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getPosition() {
        return this.position;
    }
}
