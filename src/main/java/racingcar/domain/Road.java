package racingcar.domain;


public class Road {

    public void move(Car car, int number) {
        if (number >= 4) {
            car.addPosition();
        }
    }
}
