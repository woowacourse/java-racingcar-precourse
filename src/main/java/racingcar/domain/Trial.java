package racingcar.domain;

public class Trial {
    private static final int MIN_NUM_OF_TRIAL = 1;

    private int trial;

    public Trial() {

    }

    public void setTrial(int trial) {
        this.trial = trial;
    }

    public boolean isValidateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
