package domain;

import java.util.Random;

public class Car {
	private static final Random random = new Random();
	private static final int MAX_RANDOM_NUM = 10;
    private final String name;
    private int position = 0;
    private int randNum;
 

    public Car(String name) {
        this.name = name;
    }
    
    public void makeRandomNum() {
    	this.randNum = random.nextInt(MAX_RANDOM_NUM);
    }
    
}
