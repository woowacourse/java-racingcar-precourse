package domain;

import java.util.ArrayList;

public class WinnerPrinter {
    private ArrayList<Car> carList;
    private int maxDistance;

    WinnerPrinter(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public void PrintWinner() {
        FindMaxDistance();
    }

    private void FindMaxDistance() {
        for (int carOrder = 0; carOrder < this.carList.size(); carOrder++) {
            SaveIfIsMaxDistance(carOrder);
        }
    }

    private void SaveIfIsMaxDistance(int carOrder) {
        int carPosition = this.carList.get(carOrder).getPosition();
        if (maxDistance < carPosition) {
            maxDistance = carPosition;
        }
    }


}
