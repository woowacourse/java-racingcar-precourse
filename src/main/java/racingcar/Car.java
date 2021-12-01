package racingcar;

public class Car {
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    String getName(){
        return this.name;
    }

    private int position = 0;

    int getPosition(){
        return this.position;
    }

    void moveIfNumGTE4(int num){
        if (num >= 4){
            this.position++;
        }
    }
}
