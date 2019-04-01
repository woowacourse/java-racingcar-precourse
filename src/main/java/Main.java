/*
 * @(#)Main.java
 *
 * v 0.0.0
 *
 * 2019.04.01
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */
import com.kwonmc.racing.CarGame;

/**
 * 자동차 게임을 진행하는 로직을 수행하는 main 이 있는 클래스
 *
 * @version 0.0.0
 * @author kwonmc
 */
public class Main {
    public static void main(String[] args) {
        CarGame carGame = new CarGame();

        int runs = carGame.getRuns();

        carGame.printResultTitle();
        while(runs-- > 0) {
            carGame.runEachGame();
            carGame.printResultEachGame();
        }
        carGame.printResultTotal();
    }
}
