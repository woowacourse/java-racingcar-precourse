package com.nekisse;

import java.util.Random;

public class GameRandomNumberGenerator implements RandomNumberGenerator {

    public static final int LIMIT_NUMBER = 10;

    @Override
    public int generateRandomNumber() {
        return new Random().nextInt(LIMIT_NUMBER);
    }
}
