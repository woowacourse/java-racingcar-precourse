package com.github.seokhyeonchoi.game.racingcar;

/**
*
* @description : Car Class
* @package : com.github.seokhyoenchoi.game.racingcar
* @author : 최석현
* 
*/
public class Car {
    private final String name;
    private int position = 0;
    
	private static int MOVE_FLAG_LOWER_BOUNDARY = 0;
	private static int MOVE_FLAG_UPPER_BOUNDARY = 9;
	private static int MOVE_BOUNDARY = 4;
	
    public Car(String name) {
        this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    
    public int getPosition() {
    	return position;
    }

    public void move() {
    	if(moveFlag()) {
    		position++;
    	}
    }
    
    /**
	 * @desc MOVE_BOUNDARY 이상의 난수가 발생되면 true return
	 */
    private boolean moveFlag() {
    	int flag = (int)(Math.random()*MOVE_FLAG_UPPER_BOUNDARY + MOVE_FLAG_LOWER_BOUNDARY);
    	return (flag >= MOVE_BOUNDARY);
    }

	@Override
	public String toString() {
		String str = name + " : ";
		
		for(int i=0; i<position; i++) {
			str += "-";
		}
		
		return str;
	}    
}
