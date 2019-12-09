/*
 * 클래스 이름   Main
 * 버전 정보    1.0
 * 날짜        2019.12.05
 * 저작권      YebinK
 */

package domain;

/**
 * 자동차 경주 게임을 준비(PrepareGame)하고, 플레이(StartGame)한다.
 */

public class Main {

    public static void main(String[] args) {

        PrepareGame prepareGame = new PrepareGame();
        prepareGame.prepare();

        StartGame startGame = new StartGame();
        startGame.start(prepareGame.Cars(), prepareGame.Attempts());
    }
}
