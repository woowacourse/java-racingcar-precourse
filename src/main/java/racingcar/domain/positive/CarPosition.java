package racingcar.domain.positive;

public class CarPosition implements Positive {
    private final int position;
    
    public CarPosition() {
        this(0);
    }
    
    public CarPosition(final int position) {
        this.position = position;
    }
    
    @Override
    public CarPosition increase() {
        return new CarPosition(position + 1);
    }
    
    @Override
    public int number() {
        return position;
    }
    
    @Override
    public String toString() {
        return "CarPosition{" +
                "position=" + position +
                '}';
    }
}
