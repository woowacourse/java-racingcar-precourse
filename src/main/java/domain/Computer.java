package domain;

import java.util.List;

public class Computer {
    private static final int MIN_OF_GO = 4;
    private static final int RANGE_OF_NUMBER = 9;

    public static void gameStart(List<Car> users, int howMany) {
        for(int i =0; i<users.size(); i++){
            for(int k =0; k<howMany; k++){
                Car.makeResult(users.get(i),notifyGoOrStop());
            }
        }
    }

    private static int makeRandomNumber(){
        return (int)(Math.random() * RANGE_OF_NUMBER);
    }

    private static boolean notifyGoOrStop(){
        if(makeRandomNumber()>=MIN_OF_GO)
            return true;
        return false;
    }

}
