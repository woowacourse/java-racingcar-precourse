package racingcar.domain;

public class Trial {
    private static final int MIN_NUM_OF_TRIAL = 1;

    private int trial;

    public Trial(String trial) {
        this.trial = Integer.parseInt(trial);
    }
}
