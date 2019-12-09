package com.minuyim.race.utils;

import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random();
    
    public static int generateRandom() {
        int randomNumber = random.nextInt(Constants.RANDOM_MAX_NUMBER
                - Constants.RANDOM_MIN_NUMBER + 1) + Constants.RANDOM_MIN_NUMBER;
        
        return randomNumber;
    }
}