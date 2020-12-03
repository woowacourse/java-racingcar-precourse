package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;
    private static final int START_INCLUSIVE=0;
    private static final int END_INCLUSIVE=9;
    private static final int FOWARD_BEYOND=4;

    public Car(String name) {
        this.name = name;
    }

    public String getName(){return this.name;}

    public int getPosition(){return this.position;}

    /* 랜덤 난수를 발생시켜 전진 여부를 결정하는 메소드 */
    public boolean determineMove(){
        int random= RandomUtils.nextInt(START_INCLUSIVE,END_INCLUSIVE);
        if(random>=FOWARD_BEYOND){
            return true;
        }
        return false;
    }

    public void movePosition(){
        if(determineMove()){
            this.position++;
        }
    }
}
