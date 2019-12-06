package seonggyu.cars;

import java.util.Random;

public class Car {
    private static final int RAND_NUM_RANGE = 10;
    private static final int THRESHOLD = 3;
    
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
    	return this.name;
    }
    
    public int getPosition() {
    	return this.position;
    }
    
    public void decidePosition() {
    	Random RANDOM = new Random();
		if(RANDOM.nextInt(RAND_NUM_RANGE) > THRESHOLD ) {
			this.position++;
		}
    }
    
    public void printNameAndPosition() {
    	System.out.print(this.name + " : ");
    	for (int i = 0; i < this.position; i++) {
    		System.out.print("-");
    	}
    	System.out.println();
    }
}
