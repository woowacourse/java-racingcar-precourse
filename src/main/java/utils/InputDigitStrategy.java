package utils;

public class InputDigitStrategy implements DigitStrategy {
    private int inputNumber;

    public InputDigitStrategy(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    @Override
    public int getDigit() {
        return inputNumber;
    }
}
