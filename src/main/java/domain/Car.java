package domain;

public class Car implements RacingCar {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void race() {

    }
    private void go() {
        position += RacingGameConfig.STEP;
    }

    @Override
    public int getPosition() {
        return 0;
    }

    // 추가 기능 구현
}
