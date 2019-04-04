package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    // 추가 기능 구현  
    public void move() {
    	Random rand = new Random();
    	int randNum = rand.nextInt(10);
    	if (randNum < 4) {
    		return;
    	}
    	this.position += 1;
    }
    
    public void printStatus() {
    	String status = "";
    	for (int i = 0; i < this.position; i++) {
    		status += "-";
    	}
    	String printStr = String.format("%s : %s", this.name, status);
    	System.out.println(printStr);
    }
}
