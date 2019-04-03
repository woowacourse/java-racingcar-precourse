/*
 *  클래스 이름 : Application.java
 *
 *  버전 정보 :
 *
 *  날짜 : 2019-03-29
 *
 *  저작권 : 이예지
 */

package domain;

public class Application {

	public static void main(String[] args) {

		CarGame carGame = new CarGame(new UserInput());
		carGame.playGame();

	}

}
