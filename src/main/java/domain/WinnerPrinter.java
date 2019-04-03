package domain;

import java.util.ArrayList;

public class WinnerPrinter {
    private ArrayList<Car> carList;
    private int maxDistance;
    private ArrayList<String> winnerList;

    WinnerPrinter(ArrayList<Car> carList) {
        this.carList = carList;
        winnerList = new ArrayList<>();
    }

    public void PrintWinner() {
        FindMaxDistance();
        FindWinner();
        for (int winner = 0; winner < winnerList.size() - 1; winner++) {
            System.out.print(winnerList.get(winner) + ",");
        }
        System.out.println(winnerList.get(winnerList.size() - 1) + "가 최종 우승했습니다.");
    }

    private void FindMaxDistance() {
        for (int carOrder = 0; carOrder < this.carList.size(); carOrder++) {
            SaveMaxDistanceIfIsTrue(carOrder);
        }
    }

    private void SaveMaxDistanceIfIsTrue(int carOrder) {
        int carPosition = this.carList.get(carOrder).getPosition();
        if (maxDistance < carPosition) {
            maxDistance = carPosition;
        }
    }

    private void FindWinner() {
        for (int carOrder = 0; carOrder < this.carList.size(); carOrder++) {
            SaveWinnerNameIfIsTrue(carOrder);
        }
    }

    private void SaveWinnerNameIfIsTrue(int carOrder) {
        Car car = this.carList.get(carOrder);
        if (maxDistance == car.getPosition()) {
            winnerList.add(car.getName());
        }
    }


}
