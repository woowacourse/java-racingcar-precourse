package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    void moveIfNumGTE4(int num){
        if (num >= 4){
            this.position++;
        }
    }

    int getPosition(){
        return this.position;
    }
}
