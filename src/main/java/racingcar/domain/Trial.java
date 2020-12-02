package racingcar.domain;

public class Trial {
    private static final int MIN_NUM_OF_TRIAL = 1;

    private int trial;

    public Trial(String trial) {
        this.trial = Integer.parseInt(trial);
    }

    public int getTrial() {
        return trial;
    }

    public static boolean isValidateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean isMoreThanZero(String number) {
        return Integer.parseInt(number) >= MIN_NUM_OF_TRIAL;
    }
}
