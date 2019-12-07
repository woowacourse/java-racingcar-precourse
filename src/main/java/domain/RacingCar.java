package domain;

import java.util.Random;

public class RacingCar extends Car implements Raceable {

    public RacingCar(String name) {
        super(name);
    }
    public RacingCar(int id, String name, int position) {
        super(id, name, position);
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
}
