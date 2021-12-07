package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public static void play(List<Car> carList){
        for(Car car: carList){
            int number = getRandomNumber();
            if(number>3){
                move(car);
            }
            getResult(car);
        }
    }

    private static void getResult(Car car) {
        String line = drawLine(car.position);
        System.out.println(car.name + " : " + line);
    }

    private static String drawLine(int position) {
        String line = "";
        for(int i=0; i<position; i++){
            line = line + "-";
        }
        return line;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static void move(Car car) {
        // 자동차에 position 변수를 증가시킨다.
        car.position++;
    }

    public static int getCarPosition(Car car) {
        return car.position;
    }

    public static String getCarName(Car car) {
        return car.name;
    }

    public static List<Car> makeCarNameToCarList(List<String> parsedCarName){
        List<Car> carList = new ArrayList<Car>();
        for(String carName: parsedCarName){
            carList.add(new Car(carName));
        }
        return carList;
    }
}
