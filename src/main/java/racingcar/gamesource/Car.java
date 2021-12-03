package racingcar.gamesource;

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
        int randomNumber = Randoms.pickNumberInRange(0,9);

        if(randomNumber >=4){
            ++position;
        }

    }

    @Override
    public String toString(){
        StringBuilder positionToHyphens = new StringBuilder("");

        for(int i=0; i<position ; ++i){
            positionToHyphens.append('-');
        }

        return this.name + " : " + positionToHyphens;
    }
}
