package domain;

public class Car {
    private static final int FOUR_TO_NINE_GO = 4;
    private static final boolean GO = true;
    private static final boolean STOP = false;

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void moveCar(int randomNumber) { // 0과 9사이의 랜덤한 숫자를 받아 4이상이면 전진, 이하이면 정지
         if(isMoveAvailable(randomNumber)) {
            this.position.movePosition();
        }
    }

    private boolean isMoveAvailable(int randomNumber) {
        if (randomNumber >= FOUR_TO_NINE_GO) {
            return GO;
        }
        return STOP;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
