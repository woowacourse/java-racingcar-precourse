/*
 * @(#)Main.java     0.2 2019.12.09
 *
 * Copyright (c) 2019 lxxjn0.
 */

import domain.RacingGame;

/**
 * 게임 시작을 위한 Main 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.2 2019.12.09
 */
public class Main {
    /**
     * RacingGame 클래스의 객체를 생성하여 게임을 시작하는 Main 메소드.
     *
     * @param args 입력되는 매개변수 존재하지 않음.
     */
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.run();
    }
}
