package racingcar.gamesource;

import racingcar.constants.ConstMessage;
import racingcar.constants.ConstValue;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    public void drive(){
        int randomNumber = Randoms.pickNumberInRange(ConstValue.RAMDOM_NUMBER_BEGIN,ConstValue.RAMDOM_NUMBER_END);

        if(randomNumber >= ConstValue.DRIVE_POSSIBLE_BOUND){
            ++position;
        }

    }

    @Override
    public String toString(){
        StringBuilder positionToHyphens = new StringBuilder("");

        for(int i=0; i<position ; ++i){
            positionToHyphens.append('-');
        }

        return this.name + ConstMessage.NAME_POSITION_DELIMITER + positionToHyphens;
    }
}