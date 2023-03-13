package racingcar.Domain;

import racingcar.Exceptions.CarNameLengthException;

public class Car {

    private static final int CAR_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }
    private void validate(String name){
        checkValidateLength(name);
    }
    private void checkValidateLength(String name){
        if(name.length() > CAR_NAME_LENGTH){
            throw new CarNameLengthException();
        }
    }

    public void move(int moveNum) {
        if(moveNum > 4 ){
            this.position+=1;
        }
    }
    public int getPosition(){
        return position;
    }
    public String getName(){
        return name;
    }
    // 추가 기능 구현
}
