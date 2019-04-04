package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;
    Random r = new Random();
    
    public Car(String name) {
        this.name = name;
    }
    
    public void moveOrStop() {
    	int randInt = Math.abs(r.nextInt()) % 10;
    	if(randInt >= 4) {
    		++position;
    	}
    }

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
    
    

}
