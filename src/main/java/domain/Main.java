/**
 * 이 클레스는  java-racingcar 실행을 위한 클래스 이다.
 * playGame class를 생성해 start 매서드를 실행하면 게임이 시작된다.
 * <p>
 * className Main
 * version 	1.0.0
 * Date		31/03/2019
 * author	권경동
 */

package domain;

public class Main {

    public static void main(String[] args) {
        PlayGame game = new PlayGame();
        game.start();
    }
}



