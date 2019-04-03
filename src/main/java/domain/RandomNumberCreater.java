package domain;

import java.util.Random;

public class RandomNumberCreater {
    public static int createNum(){
        Random random = new Random();
        return random.nextInt(10);
    }
}
