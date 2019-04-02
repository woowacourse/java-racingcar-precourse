package domain;

public class CarRacer {
    private static final int STANDARD_OF_GOING = 4;
    private int randomNumber;

    private boolean isGo() {
        return this.randomNumber >= STANDARD_OF_GOING ? true : false;
    }

    private void GenerateRandomNumber() {
        randomNumber = (int) (Math.random() * 10);
    }
}
