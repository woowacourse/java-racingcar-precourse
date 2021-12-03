package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(){
        position += 1;
    }

    public void moveOrStop(int randomNumber, int threshold) {
        if (randomNumber >= threshold) {
            this.move();
        }
    }
}
