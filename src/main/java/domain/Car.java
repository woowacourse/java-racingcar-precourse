/*
 * Car
 * 
 * version 1.0
 * 
 * 2019. 4. 2
 * 
 * Created by Wongeun Song
 */

package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    private boolean canMove() {
		Random random = new Random();

		if(random.nextInt(10) >= 4) return true;
		return false;
	}
    
    public void move() {
    	if(this.canMove()) this.position++;
	}
}
