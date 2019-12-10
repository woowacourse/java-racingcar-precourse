package racing.domain;

public class RandomNumberRule implements CarRunRule {
    private static final int RANDOM_NUMBER_SIZE = 10;
    private static final int MIN_MOVING_NUMBER = 4;

    @Override
    public boolean canRun() {
        int randomNumber = (int) (Math.random() * RANDOM_NUMBER_SIZE);
        return randomNumber >= MIN_MOVING_NUMBER;
    }
}
