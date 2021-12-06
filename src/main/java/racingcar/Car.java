package racingcar;

import racingcar.domain.RandomNumberGenerator;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String printCurrentPosition(){
        StringBuffer result=new StringBuffer();
        for (int i = 0; i < this.position; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public void goForward() {
        if (isMoreThanFour()) {
            this.position++;
        }
    }

    private boolean isMoreThanFour() {
        return RandomNumberGenerator.createRandomNumber() >= 4;
    }
}
