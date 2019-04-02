package domain;

import java.util.ArrayList;

public class GameManager {
    private int carsize;
    private int count;
    private int maxPosition;
    private StringBuilder winner;
    private ArrayList<Car> cars;

    GameManager() {
        User user = new User();
        cars = user.getCar();
        carsize = cars.size();
        count = user.getcount();
        maxPosition = 0;
        winner = new StringBuilder();
    }

    public void start() {
        for (int i = 0; i < count; i++) {
            front();
            System.out.println();
        }
        gamefinish();
    }

    public void front() {
        for (int j = 0; j < carsize; j++) {
            Car c = cars.get(j);
            c.move();
            c.print();
            maxPosition = Math.max(maxPosition, c.getPosition());
        }
    }

    /**
     * gamefinish() : 게임 상태 확인
     */
    private void gamefinish() {
        for (int i = 0; i < carsize; i++) {
            Car c = cars.get(i);
            win(c);
        }
        winPrint();
    }

    private void win(Car c) {
        if (c.getPosition() == maxPosition) {
            winner.append(c.getName() + " ,");
        }
    }

    private void winPrint() {
        System.out.println(winner.toString() + "가 최종 우승했습니다.");
    }

}

