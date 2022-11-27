package racingcar.domain.positive;

public class Positive {
    private final int positiveNumber;
    
    public Positive() {
        this(0);
    }
    
    public Positive(final int positiveNumber) {
        this.positiveNumber = positiveNumber;
    }
    
    public Positive increase() {
        return new Positive(positiveNumber + 1);
    }
    
    public int number() {
        return positiveNumber;
    }
    
    @Override
    public String toString() {
        return "Positive{" +
                "positiveNumber=" + positiveNumber +
                '}';
    }
}
