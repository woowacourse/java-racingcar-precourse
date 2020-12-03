package utils;

public class InputDigit implements DigitStrategy {
    private int inputNumber;

    public InputDigit(int inputNumber){
        this.inputNumber = inputNumber;
    }

    @Override
    public int getDigit() {
        return inputNumber;
    }
}
