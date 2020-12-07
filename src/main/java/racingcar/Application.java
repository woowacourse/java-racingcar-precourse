package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        // Test
        ArrayList<Car> carList = new ArrayList<Car>();
        carList.add(new Car("a"));
        carList.add(new Car("b"));

        for(int i = 0; i <5; i++){
            System.out.println("#"+(i+1));
            for (Car nowCar : carList){
                nowCar.moveCar();
                nowCar.printCarPosition();
            }
        }
    }
}
