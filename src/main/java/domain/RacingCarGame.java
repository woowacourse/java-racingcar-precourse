/*
 * 레이싱 게임을 위한 클래스
 *
 * @version 1.0
 *
 * @date 2019.12.08
 * 
 * @author Jung dahee
 */

package domain;

import java.util.Scanner;

public class RacingCarGame {
	
	Car cars[];
	String sCars[];
	int max;
	int gameCnt;
	Scanner sc = new Scanner(System.in);
	
	public void start() {
		inputCars();
		setCars();
		inputGameCnt();
		runRace();
	}
}
