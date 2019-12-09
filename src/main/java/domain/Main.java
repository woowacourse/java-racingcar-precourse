/*
 * @(#)Main.java        2019/12/10
 *
 *
 */

package domain;

/**
 * 자동차 경주 게임 실행을 위한 메인클래스
 *
 * @version		0.1 2019년 12월 10일
 * @author		YerinCho          
 */

public class Main {
    
    static RacingGame racinggame = new RacingGame();

    public static void main(String[] args) {
	racinggame.run();
    }
    
}