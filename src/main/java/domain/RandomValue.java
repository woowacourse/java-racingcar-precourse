/*
 *  @CarController.java
 *
 *  @Version: 0.2
 *
 *  @Date: 2019.12.09
 *
 *  @Author: pandahun
 */
package domain;

import java.util.Random;

public class RandomValue {

    private static final int MAX_NUMBER = 10;

    public int getRandomValue() {
        return new Random().nextInt(MAX_NUMBER);
    }

}
