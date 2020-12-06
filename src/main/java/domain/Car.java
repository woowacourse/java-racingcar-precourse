package domain;

public class Car {
    private static final int FOUR_TO_NINE_GO = 4;

    private final Name name;
    private int position = 0;

    public Car(String name) {
        this.name = new Name(name);
    }

    // 0~9의 랜덤한 숫자를 매개변수로 입력
    public void moveCar(int randomNumber) {
        if (randomNumber >= FOUR_TO_NINE_GO) {
            this.position += 1;
        }
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
