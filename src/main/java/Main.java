/*
 * @(#)Main.java        0.2 2019/04/02
 *
 *
 */

import domain.RacingCarGame;

/**
 * RacingCarGame 실행을 위한 Main클래스 입니다.
 *
 * @author 반선호
 * @version 0.2 2019년 4월 02일
 */
public class Main {
    public static void main(String[] args) {
        RacingCarGame game = new RacingCarGame();
        game.gameStart();
    }
}
