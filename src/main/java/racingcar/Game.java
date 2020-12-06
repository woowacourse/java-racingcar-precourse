package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Game {
    static final int START_POSITION = 0;
    private int gameCnt = 0;
    private List<Car> carList;

    public void setGame(int cnt, List<Car> carList) {
        this.gameCnt = cnt;
        this.carList = carList;
    }

    public void start() {
        System.out.println("실행 결과");
        for (int i = 0; i < gameCnt; i++) {
            play();
            print();
        }
        printWinner();
    }

    private void printWinner() {
        System.out.print("최종우승자: ");
        List<String> winnerList = getWinner();
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i));
            if(i != winnerList.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    private List<String> getWinner() {
        int maxPosition = START_POSITION;
        List<String> winnerList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            int tmpPosition = carList.get(i).getPosition();
            maxPosition = Math.max(maxPosition, tmpPosition);
        }

        for (int i = 0; i < carList.size(); i++) {
            if (maxPosition == carList.get(i).getPosition()) {
                winnerList.add(carList.get(i).getName());
            }
        }
        return winnerList;
    }

    private void print() {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).printCarState();
        }
        System.out.println();
    }

    private void play() {
        int[] carRandomNum = new int[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
            carRandomNum[i] = RandomUtils.nextInt(0, 9);
            checkMove(i, carRandomNum[i]);
        }
    }

    private void checkMove(int carIdx, int randomNum) {
        if (randomNum >= 4) {
            carList.get(carIdx).updatePosition();
        }
    }

}
