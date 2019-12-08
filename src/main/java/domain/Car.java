package domain;

import java.util.Random;

public class Car {
	private static final Random random = new Random();
	private static final int MAX_RANDOM_NUM = 10;
	private static final int CAN_MOVE = 4;
	private static final int CANT_MOVE = 3;
	private static final int STAY = 0;
	private static final String IS = " : ";
    private final String name;
    private int position = 0;
    private int randNum;
 

    public Car(String name) {
        this.name = name;
    }
    
    public void makeRandomNum() {
    	this.randNum = random.nextInt(MAX_RANDOM_NUM);
    }
    
    public void move() {
    	 if (randNum >= CAN_MOVE) {
    		 this.position++;
    	 } else if (randNum <= CANT_MOVE) {
    		 this.position += STAY;
    	 }
    }
    
    public void printCarPosition(char shape) {
    	System.out.println(this.name + IS + printShapes(shape));
    }
    
    private String printShapes(char shape) {
    	String shapes = "";
    	for (int i = 0; i < this.position; i++) {
    		shapes += shape;
    	}
    	return shapes;
    }
    
}
