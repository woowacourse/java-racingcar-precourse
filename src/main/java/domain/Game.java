/**
 * Game.java
 * 아직 리팩토링 중...
 * 우아한테크코스 프리코스 2주차.
 * Original code https://github.com/hotheadfactory/java-racingcar-precourse
 * Version: v0.0.1, 2019.12.05 (c) 정회형
 */
package domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private User user = new User();

    public void startGame() {
        List<Car> carsList = enrollPlayers();
        startRace(carsList, user.getTurnNumber());
        printWinner(carsList);
    }

    private List<Car> enrollPlayers() {
        String[] carArray = user.inputCarNames();
        List<Car> carsList = new ArrayList<Car>();
        for (String oneCar : carArray) {
            carsList.add(new Car(oneCar));
        }
        return carsList;
    }

    private void startRace(List<Car> carsList, int turnNumber) {
        System.out.println("실행 결과");
        for (int i = 0; i < turnNumber; i++) {
            playOneTurn(carsList);
        }
    }

    private void playOneTurn(List<Car> carsList) {
        for (Car oneCar : carsList) {
            oneCar.playTurn();
        }
        System.out.println();
    }

    private static void printWinner(List<Car> carsList) {
        List<String> winnerList = getWinner(carsList);
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.printf("%s", winnerList.get(i));
            if (i != winnerList.size() - 1) {
                System.out.printf(", ");
            }
        }
        System.out.printf("님이 최종 우승했습니다.\n");
    }

    private static List<String> getWinner(List<Car> carsList) {
        int maxScore = getMaxScore(carsList);
        List<String> winnerList = new ArrayList<String>();
        for (Car oneCar : carsList) {
            if (oneCar.getPosition() == maxScore) {
                winnerList.add(oneCar.getName());
            }
        }
        return winnerList;
    }

    private static int getMaxScore(List<Car> carsList) {
        int maxScore = 0;
        for (Car oneCar : carsList) {
            int thisCarPosition = oneCar.getPosition();
            if (thisCarPosition > maxScore) {
                maxScore = thisCarPosition;
            }
        }
        return maxScore;
    }

}
