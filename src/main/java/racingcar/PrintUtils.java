package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static constant.Constant.FINAL_WINNER_MESSAGE;
import static constant.Constant.INITIAL_VALUE;

public class PrintUtils {
    public static void printByAttemp(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int i = INITIAL_VALUE; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printFinalResult(List<Car> carList) {
        List<String> winnerList = findWinnerList(carList);

        System.out.print(FINAL_WINNER_MESSAGE);
        int winnerListSize = winnerList.size();

        for (int i = INITIAL_VALUE; i < winnerListSize - 1; i++) {
            System.out.print(winnerList.get(i) + ", ");
        }
        System.out.println(winnerList.get(winnerListSize - 1));
    }

    private static ArrayList<String> findWinnerList(List<Car> carList) {
        HashMap<Integer, ArrayList<String>> rankMap = new HashMap<>();
        int maxPosition = INITIAL_VALUE;

        for (Car car : carList) {
            int carPosition = car.getPosition();
            maxPosition = Math.max(maxPosition, carPosition);

            if (!rankMap.containsKey(carPosition)) {
                rankMap.put(carPosition, new ArrayList<>());
            }
            rankMap.get(carPosition).add(car.getName());
        }
        return rankMap.get(maxPosition);
    }

}
