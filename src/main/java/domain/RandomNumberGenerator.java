package domain;

import domain.interfaces.NumberGenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private Random random = new Random();

    @Override
    public int getNumber() {
        return random.nextInt(MIN + MAX + 1) - MIN;
    }
}
