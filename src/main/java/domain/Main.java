/*
 * @(#)Main.java		2019/4/4
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * Main 클래스는 객체 RacingGame을 시작하는 기능을 합니다. 
 * 
 * @version			1.00 2019년 4월 4일
 * @author 			한준모
 */

package domain;

public class Main {
		public static void main(String[] args) {
				RacingGame game = new RacingGame();
				game.runGame();
		}
}
