package domain;

import java.util.Random;

public class Car implements RacingCar {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void race() {
        if (canGo()) {
            go();
        }

    }
    private boolean canGo() {
        int randomNumber = generateRandomNumber();
        return RacingGameConfig.STANDARD_TO_GO < randomNumber;
    }
    private int generateRandomNumber() {
        Random randomGenerator = new Random();
        //todo: check java convention
        return randomGenerator.ints(RacingGameConfig.MIN_RANDOM_NUMBER, RacingGameConfig.MAX_RANDOM_NUMBER + 1)
                .limit(1).findFirst().orElse(RacingGameConfig.MIN_RANDOM_NUMBER - 1);
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
