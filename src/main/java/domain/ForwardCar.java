package domain;

import java.util.Random;

public class ForwardCar {
    int randomNum = 0;

    void randomNum(){
        Random random = new Random();
        randomNum = random.nextInt(10);
    }

    void decideForward(Car car){
        randomNum();
        if(randomNum>=4)
            car.forwardCar();
    }
}
