package domain;

public class Car {
    private static final int FOUR_TO_NINE_GO = 4;

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    // 0~9의 랜덤한 숫자를 매개변수로 입력
    public void moveCar(int randomNumber) {
        if (randomNumber >= FOUR_TO_NINE_GO) {
            this.position.movePosition();
        }
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }
}
