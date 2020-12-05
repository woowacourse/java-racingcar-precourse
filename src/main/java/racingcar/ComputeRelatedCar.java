package racingcar;

import utils.RandomUtils;

public class ComputeRelatedCar {
    private final int START_INCLUSIVE=1;
    private final int END_INCLUSIVE=9;
    private int TEMP_MAX_NUMBER=0;
    public boolean informCanFoward(){
        int judgedRandomNumber= RandomUtils.nextInt(START_INCLUSIVE,END_INCLUSIVE);
        if(judgedRandomNumber<4){
            return false;
        }
        return true;
    }
    public void getMaxFoward(Car[] tmpCarObjectArrayParameter){

        for(int i=0;i<tmpCarObjectArrayParameter.length;i++) {
            if (this.TEMP_MAX_NUMBER < tmpCarObjectArrayParameter[i].getPosition()) {
                this.TEMP_MAX_NUMBER = tmpCarObjectArrayParameter[i].getPosition();
            }
        }
    }
    public int getWinnerNumber(Car[] tmpCarObjectArrayParameter){
        getMaxFoward(tmpCarObjectArrayParameter);
        int countWinnerNumber=0;
        for(int i=0;i<tmpCarObjectArrayParameter.length;i++){
            if(this.TEMP_MAX_NUMBER==tmpCarObjectArrayParameter[i].getPosition()){
                countWinnerNumber+=1;
            }
        }
        return countWinnerNumber;
    }

}
