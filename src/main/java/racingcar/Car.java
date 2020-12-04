package racingcar;

public class Car {
    private final String name;
    private int position = 0;
    private int MOVE_LIMIT = 4;

    public Car(String name) {
        this.name = name;
    }

    public void moveIfRandomNumberIsBiggerThanLimit(int randomNumber) {
        if(randomNumber > MOVE_LIMIT){
            position++;
        }
    }
}
