package racingcar;

import utils.RandomUtils;

public class ComputeRandomNumber {
    private final int START_INCLUSIVE=1;
    private final int END_INCLUSIVE=9;
    public boolean informCanFoward(){
        int judgedRandomNumber= RandomUtils.nextInt(START_INCLUSIVE,END_INCLUSIVE);
        if(judgedRandomNumber<4){
            return false;
        }
        return true;
    }
}
