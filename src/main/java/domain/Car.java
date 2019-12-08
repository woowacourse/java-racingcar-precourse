package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() { this.position++; }

    public void displayCarPostion() {
        System.out.print(name + " : ");
        for(int i=0; i<position; i++) {
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
