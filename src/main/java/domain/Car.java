package domain;

public class Car {
    private static final int ENOUGH_LIMIT = 4;
    private final Name name;
    private int position = 0;

    public Car(Name name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void move(Integer randomInput) {
        if (enough(randomInput)) {
            this.position++;
        }
    }

    public Boolean enough(Integer randomInput) {
        return randomInput >= 4;
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
