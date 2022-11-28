package racingcar.domain;

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
    
    public boolean isSame(final int number) {
        return positiveNumber == number;
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
