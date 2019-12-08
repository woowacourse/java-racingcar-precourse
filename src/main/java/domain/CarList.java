package domain;

import java.util.ArrayList;

public class CarList {

    private static ArrayList<Car> carList;

    public CarList() {
        this.carList = new CarNameCheck().splitCarName();
    }

    private static int howManyWin() {
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
