package domain;

import java.util.Random;

public class CarMover {
    public static void repeat(int cnt){
        for(int i=0; i<cnt; i++)
            moveOneStep();
    }

    private static void moveOneStep(){
        for(int i=0; i<CarRepository.carPark.size(); i++)
            if(RandomNumberCreater.createNum()>=4)
                CarRepository.carPark.get(i).move();
        InfoPrinter.printCurrent();
    }
}
