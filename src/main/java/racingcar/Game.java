package racingcar;

import utils.RandomUtils;

import java.util.List;

public class Game {
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
