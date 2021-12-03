package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;
    
	static final int startNum = 0;
	static final int endNum = 9;
	
    public Car(String name) {
        this.name = name;
    }
    int randomNumber() {
    	
    	int rand = Randoms.pickNumberInRange(startNum,endNum);
    	//System.out.println(rand); 랜덤수 확인
     	return rand;
    }
    
    void positionMove(int n) {
    	if(n >= 4) {
    		this.position += 1 ;
    	}
    	
    } // 추가 기능 구현
    void visual() {
    	System.out.print(this.name +" : " );
    	for(int i = 0; i< this.position; i++) {
    		System.out.print("-");
    	}
    	System.out.println();
    }
    
    
    int getPosition() {
		return this.position;
    	
    }
    String getName() {
    	return this.name;
    	
    }
    
}
