package com.minuyim.race.utils;

import java.util.Random;

public class RandomGenerator {
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static Random random = new Random();
    
    public static int generateRandom() {
        
        int randomNumber = random.nextInt(RANDOM_MAX_NUMBER
                - RANDOM_MIN_NUMBER + 1) + RANDOM_MIN_NUMBER;
        
        return randomNumber;
    }
}
