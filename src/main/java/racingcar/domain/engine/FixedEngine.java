package racingcar.domain.engine;

public class FixedEngine implements Engine {

    private final int fixedDigit;

    public FixedEngine(int fixedDigit) {
        this.fixedDigit = fixedDigit;
    }

    @Override
    public int getDigit() {
        return this.fixedDigit;
    }
}
