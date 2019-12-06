package com.woowa.racingcar;

public class RacingCar {
    public static void main(String[] args) {
        Player user = new Player();
        Computer com = new Computer();

        com.setCarList(user.inputCarName());
        int playTime = user.inputTime();

        System.out.println("\n실행결과");
        for (int i = 0; i < playTime; i++) {
            com.checkFoward();
        }
        com.showResult();
    }
}