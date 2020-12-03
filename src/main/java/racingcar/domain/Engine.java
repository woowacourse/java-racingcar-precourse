package racingcar.domain;

import racingcar.generator.RandomNumberGenerator;
import utils.RandomUtils;

import java.util.Random;

public class Engine {
    private static final int MOVABLE_THRESHOLD = 4;
    public int run(){
        int randomValue = RandomNumberGenerator.generateRandomNumber();
        if(randomValue < MOVABLE_THRESHOLD){
            return 0;
        }
        return 1;
    }
}
