/*
 * @(#)Computer.java        2019/12/10
 *
 *
 */

package domain;

/**
 * 임의의 값 설정을 위한 Computer 클래스
 *
 * @version		0.1 2019년 12월 10일
 * @author		YerinCho          
 */

public class Computer {
    private static final int MAX_RANDOM_NUMBER=9;
    
    public int createRandNum() {
	int randnum=(int)(Math.random()*MAX_RANDOM_NUMBER)+1;
	return randnum; 
    }
    
}
