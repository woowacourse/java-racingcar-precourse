package domain;

import java.util.Random;

public class ForwardCar {
    int randomNum = 0;

    void randomNum(){
        Random random = new Random();
        randomNum = random.nextInt(10) + 1;
    }
}
