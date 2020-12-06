package racingcar;

import java.util.ArrayList;
import java.util.Collections;

public class GamePlay {
    final static String stateBar = "-";
    final static String executeResult = "실행 결과";
    final static String finalWinnerIs = "최종 우승자: ";

    public static void play(int trackLength, ArrayList<Car> carList) {
        System.out.println();
        System.out.println(executeResult);
        for (int i = 0; i < trackLength; i++) {
            oneStep(carList);
        }
    }

    static void oneStep(ArrayList<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            int nowPosition = carList.get(i).move();
            inputAndOutput.outputOneStepName(carList.get(i).getName());
            inputAndOutput.outputOneStepStateBar(nowPosition, stateBar);
            System.out.println();
        }
        System.out.println();
    }

    static int farthestPosition(ArrayList<Car> carList) {
        ArrayList<Integer> lastPositions = new ArrayList<Integer>();
        for (int i = 0; i < carList.size(); i++) {
            int nowPosition = carList.get(i).getPosition();
            lastPositions.add(nowPosition);
        }
        return Collections.max(lastPositions);
    }

    static ArrayList<String> whoIsWinner(ArrayList<Car> carList) {
        ArrayList<String> result = new ArrayList<String>();
        int winPosition = farthestPosition(carList);
        for (int i = 0; i < carList.size(); i++) {
            if (winPosition == carList.get(i).getPosition()) {
                result.add(carList.get(i).getName());
            }
        }
        return result;
    }

    static void printWinner(ArrayList<String> winnerList) {
        System.out.print(finalWinnerIs);
        for (int i = 0; i < winnerList.size(); i++) {
            String winner = winnerList.get(i);
            System.out.print(winner);
            if (i != winnerList.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
