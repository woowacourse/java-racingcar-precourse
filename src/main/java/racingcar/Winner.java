package racingcar;

import java.util.ArrayList;

public class Winner {
    private static final int ONLY_ONE_WINNER = 1;
    private static final ArrayList<String> winnerList = new ArrayList<>();

    public void getWinner(ArrayList<Car> carList) {
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : carList) {
            if (car.getPosition() < maxPosition) {
                continue;
            }
            if (car.getPosition() > maxPosition) {
                winnerList.clear();
                maxPosition = car.getPosition();
            }
            winnerList.add(car.getName());
        }
        this.printWinner();
    }

    private void printWinner() {
        if (winnerList.size() != ONLY_ONE_WINNER) {
            System.out.println("최종 우승자 : " + String.join(", ", winnerList));
            return;
        }
        System.out.println("최종 우승자 : " + winnerList.get(0));
    }
}
