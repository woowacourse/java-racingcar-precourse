/*
 * 클래스 이름   Main
 * 버전 정보    1.0
 * 날짜        2019.12.05
 * 저작권      YebinK
 */

package domain;

public class Main {

    public static void main(String[] args) {

        PrepareGame prepareGame = new PrepareGame();
        prepareGame.prepare();

        StartGame startGame = new StartGame();
        startGame.start(prepareGame.Cars(), prepareGame.Attempts());
    }
}
