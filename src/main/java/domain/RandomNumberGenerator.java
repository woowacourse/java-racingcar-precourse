package domain;

public class RandomNumberGenerator {
    private int randomNumber;

    public void GenerateRandomNumber() {
        randomNumber = (int) (Math.random() * 10);
    }
}
