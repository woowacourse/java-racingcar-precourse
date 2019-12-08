package domain;

public class Car {
    private static final int FIRST_CAR = 0;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() { this.position++; }

    public void displayCarPosition() {
        System.out.print(name + " : ");
        for(int i=FIRST_CAR; i<position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
    // 추가 기능 구현
}
