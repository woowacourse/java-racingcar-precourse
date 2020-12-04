package racingcar;

import java.util.ArrayList;

public class Track {

    private ArrayList<Car> cars = new ArrayList<Car>();
    private int loopTime;

    public Track(int loopTime) {
        this.loopTime = loopTime;
    }

    public void enterTrack(Car car){
        cars.add(car);
    }
}
