/*
 *  클래스 이름 : RandomNumber.java
 *
 *  버전 정보 :
 *
 *  날짜 : 2019-03-29
 *
 *  저작권 : 이예지
 */

package utils;

import java.util.*;

public class RandomNumber {

	public int getRandomNumber(){
		Random random = new Random();
		int	randomNumber = random.nextInt(10);

		return randomNumber;
	}
}
