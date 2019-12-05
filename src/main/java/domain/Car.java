package domain;

import java.util.Arrays;
import java.util.Comparator;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPosition() {
        return this.position;
    }
    
    public void movePositionByOne() {
        this.position++;
    }
    
    public static void sortByPosition(Car[] cars) {
        Arrays.sort(cars, new CarComparator());
    }
    
    private static class CarComparator implements Comparator<Car> {
        @Override
        public int compare(Car car1, Car car2) {
            if (car1.getPosition() < car2.getPosition()) {
                return 1;
            }
            if (car1.getPosition() > car2.getPosition()) {
                return -1;
            }
            return 0;
        }
    }
}
