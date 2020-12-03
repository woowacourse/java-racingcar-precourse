package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        if(RacingCarMovement.moveCar()) {
            this.position += 1;
        }
    }

    public String getCarName() {
        return name;
    }

    public int getCarPosition() {
        return position;
    }
}
