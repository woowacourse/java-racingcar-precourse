package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    // 추가 기능 구현
    
    public String getName() {
    	return this.name;
    }
    
    public int getPosition() {
    	return this.position;
    }
    
    public boolean move() {
    	Random rand = new Random();
    	int randNum = rand.nextInt(10);
    	if (randNum < 4) {
    		return false;
    	}
    	this.position += 1;
    	return true;
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
