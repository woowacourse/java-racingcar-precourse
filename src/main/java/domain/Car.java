package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public String getName() {
        return this.name;
    }

    public void setForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public void positionPrint() {
        System.out.print(name);
        System.out.print(" : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

}
