/*
 * @(#)Message.java        2019/12/10
 *
 *
 */

package domain;

/**
 * 자동차 경주 게임의 결과를 출력하기 위한 Message 클래스
 *
 * @version		0.1 2019년 12월 10일
 * @author		YerinCho          
 */

import java.util.ArrayList;

public class Message {
    
    public void playResult(String name, int position) {
	System.out.print(name+" : ");
	
	/*각 자동차의 position 크기만큼 '-' 출력*/
	for(int i=0;i<position;i++) {
	    System.out.print('-');
	}
	System.out.println();
    }
    
    public void judgeWinner(ArrayList<String> winner) {
	int size=winner.size();
	for(int i=0;i<size;i++) {
	    System.out.print(winner.get(i));
	    
	    /*우승자가 2명 이상인 경우에만 ',' 출력*/
	    if((size>1) && i!=size-1) {
		System.out.print(", ");
	    }
	}
	System.out.println("(이)가 최종 우승했습니다!");
    }
}
