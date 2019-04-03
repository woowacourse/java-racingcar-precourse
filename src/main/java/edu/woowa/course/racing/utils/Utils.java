package edu.woowa.course.racing.utils;

import java.util.Random;

/**
*@version 1.00 2019/04/03
*@author 조재훈
*/
public class Utils {

	public static Random random = new Random();
	public static final int RANDOM_SCOPE = 9;
	
	public static int getRandomInt() {
		return 1 + random.nextInt(RANDOM_SCOPE);
	}
}
