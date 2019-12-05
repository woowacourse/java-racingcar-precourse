package com.minuyim.race.utils;

import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random();
    
    public static double generateRandom() {
        double randomNumber = random.nextDouble() 
                * (Constants.RANDOM_MAX_NUMBER - Constants.RANDOM_MIN_NUMBER)
                + Constants.RANDOM_MIN_NUMBER;
        
        return randomNumber;
    }
}