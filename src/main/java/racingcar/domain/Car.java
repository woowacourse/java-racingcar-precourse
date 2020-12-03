package racingcar.domain;

import java.util.Collections;

public class Car {
    private final String name;
    private int position = 0;
    private Engine engine = new Engine();

    public Car(String name) {
        this.name = name;
    }

    public void move(){
        position += engine.run();
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(CarToStringUtil.colonWithSpace);
        sb.append(repeatDistanceIndicatorNtimes(position));
        return sb.toString();
    }

    private String repeatDistanceIndicatorNtimes(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(CarToStringUtil.distanceIndicator);
        }
        return sb.toString();
    }

    private class CarToStringUtil{
        public static final String colonWithSpace = " : ";
        public static final String distanceIndicator = "-";
    }
}
