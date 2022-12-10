package racingcar.Message;

public enum Rule {
    MIN_SPEED(0),
    MAX_SPEED(9),
    ABLE_TO_ACCELERATE(4),
    MAX_NAME_LENGTH(5),
    MIN_NAME_LENGTH(1),
    CAR_NAME_SEPARATOR(","),
    CAR_IN_LAPSE_SEPARATOR(" : "),
    CAR_DRIVEN_DISTANCE_GAUGE("-"),
    BLANK(" ");

    private int constant;
    private String separator;


    Rule(int constant) {
        this.constant = constant;
    }

    Rule(String separator) {
        this.separator = separator;
    }

    public int getConstant() {
        return this.constant;
    }

    @Override
    public String toString() {
        return this.separator;
    }
}