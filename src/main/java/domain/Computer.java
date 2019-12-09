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
    
    public int createRandNum() {
	int randnum=(int)(Math.random()*9)+1;
	return randnum; 
    }
    
}
