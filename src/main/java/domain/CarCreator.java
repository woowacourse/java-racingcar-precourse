package domain;

import java.util.StringTokenizer;

public class CarCreator {
    public static void createCar(String cars){
        StringTokenizer st = new StringTokenizer(cars,",");
        while(st.hasMoreTokens()){
            Car car = new Car(st.nextToken());
            CarRepository.parking(car);
        }
    }
}
