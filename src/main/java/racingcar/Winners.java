package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private int maxPosition = 0;
    private final List<String> winnerNames = new ArrayList<>();

    public Winners() {
    }

    public void announceWinners(List<Car> carList) {
        selectWinners(carList);
        printWinners();
    }

    private void selectWinners(List<Car> carList) {
        for (Car c : carList) {
            int thisPosition = c.getPosition();
            if (maxPosition < thisPosition) {
                maxPosition = thisPosition;
                winnerNames.clear();
                winnerNames.add(c.getName());
                continue;
            }
            if (maxPosition == thisPosition) {
                winnerNames.add(c.getName());
            }
        }
    }

    private void printWinners() {
        int numberOfWinners = winnerNames.size();

        System.out.print("최종 우승자 : " + winnerNames.get(0));
        for (int i = 1; i < numberOfWinners; ++i) {
            System.out.print(", " + winnerNames.get(i));
        }
    }

}
