package domain.car.engine;

public class FixEngine implements Engine {

    private final int power;

    public FixEngine(int fixPower) {
        this.power = fixPower;
    }

    @Override
    public int getPower() {
        return power;
    }
}
