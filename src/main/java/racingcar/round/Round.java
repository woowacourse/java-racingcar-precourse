package racingcar.round;

public class Round {
    private int round;

    public Round(String number) {
        RoundValidation.validation(number);
        this.round = stringToInt(number);
    }

    public int getRound() {
        return this.round;
    }

    private int stringToInt(String number) {
        return Integer.parseInt(number);
    }
}
