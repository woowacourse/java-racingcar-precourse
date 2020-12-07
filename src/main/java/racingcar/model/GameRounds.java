package racingcar.model;

public class GameRounds {
    public static final String ERROR_NUMBER_OF_ATTEMPTS_IS_NOT_NATURAL_NUMBER = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private int rounds;

    public GameRounds(String rounds) {
        validateNaturalNumber(rounds);
        this.rounds = Integer.parseInt(rounds);
    }

    private void validateNaturalNumber(String rounds) {

        try {
            Integer.parseInt(rounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_OF_ATTEMPTS_IS_NOT_NATURAL_NUMBER);
        }

    }

    public int getRounds() {
        return this.rounds;
    }
}
