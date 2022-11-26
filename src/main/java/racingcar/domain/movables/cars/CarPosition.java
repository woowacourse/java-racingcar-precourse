package racingcar.domain.movables.cars;

public class CarPosition {
    private final int position;
    
    public CarPosition() {
        this(0);
    }
    
    public CarPosition(final int position) {
        this.position = position;
    }
    
    public CarPosition increase() {
        return new CarPosition(position + 1);
    }
    
    public int position() {
        return position;
    }
}
