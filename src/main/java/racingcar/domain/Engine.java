package racingcar.domain;

import racingcar.generator.RandomNumberGenerator;
import utils.RandomUtils;

import java.util.Random;

public class Engine {
    private final int MOVABLE_THRESHOLD = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public Engine(RandomNumberGenerator randomNumberGenerator){
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public int run(){
        int randomValue = randomNumberGenerator.generateRandomNumber();
        if(randomValue < MOVABLE_THRESHOLD){
            return 0;
        }
        return 1;
    }
}
