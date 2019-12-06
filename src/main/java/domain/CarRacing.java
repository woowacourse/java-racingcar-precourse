package domain;

import java.util.*;

public class CarRacing {

    private static final int RANDOM_MAX_NUMBER = 10;                 // 차가 전진할 수 있을지 결정될 때, 랜덤으로 나올 수 있는 수들의 최대 크기.
    private static final int RANDOM_PARTITION_NUMBER = 4;           // 4보다 큰 수가 나오면 차는 전진할 수 있다. 그래서 전진할 지 말지 나누는 기준이 되는 수.

    private static ArrayList<Car> getCarName(String carName) {
        List<String> name = Arrays.asList(carName.split(","));
        ArrayList<Car> carList = new ArrayList<Car>();
        for (int i = 0; i < name.size(); i++) {
            carList.add(new Car(name.get(i)));
        }
        return carList;
    }

    public static boolean canDrive() {
        Random random = new Random();
        return (random.nextInt(RANDOM_MAX_NUMBER) >= RANDOM_PARTITION_NUMBER);
    }

    private static void play(ArrayList<Car> carList) {
        for(int i = 0; i < carList.size(); i ++) {
            Car currentCar = carList.get(i);
            if (canDrive()) {
                currentCar.drive();
            }
            currentCar.printDistance();
            System.out.println();
        }
    }

    private static int howManyWin(ArrayList<Car> carList) {
        int winnersNumber = 1;
        for(int i = 0; i < carList.size()-1; i ++) {
           if (!isSamePosition(carList.get(i), carList.get(i+1))) {
               break;
           }
           winnersNumber ++;
        }
        return winnersNumber;
    }

    private static boolean isSamePosition(Car carA, Car carB) {
        return (carA.getPosition() == carB.getPosition());
    }

}