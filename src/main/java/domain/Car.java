package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goOrStop(int movings) {
        for (int i = 0; i < movings; ++i) {
            int num = (int) Math.random() * 10;
            if (num >= 4) {
                position++;
            }
        }
    }


    // 추가 기능 구현
}