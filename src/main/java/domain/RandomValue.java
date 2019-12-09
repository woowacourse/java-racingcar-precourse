/*
 *  @CarController.java
 *
 *  @Version: 0.1
 *
 *  @Date: 2019.12.06
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
