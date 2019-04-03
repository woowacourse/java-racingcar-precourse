package edu.woowa.course.racing.utils;

import java.util.Random;

/**
*@version 1.00 2019/04/03
*@author 조재훈
*/
public class Utils {
	private static Random random = new Random();
	private static final int RANDOM_SCOPE = 10;
	private static final int MOVE_THRESHOLD = 4;

	public static boolean isMove() {
		return ( getRandomInt() < MOVE_THRESHOLD ? false : true );
	}

	private static int getRandomInt() {
		return random.nextInt(RANDOM_SCOPE);
	}
}
