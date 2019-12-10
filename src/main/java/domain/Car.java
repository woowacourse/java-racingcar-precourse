package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
    	this.position = position;
    }
    public String getName() {
    	return this.name;
    }
    public int getPosition() {
    	return this.position;
    }
	int makeRandomNumber() {
		Random random = new Random();
		return random.nextInt(10);
		//make random number in range 0~9;
	}
	boolean decideGo(int randomNumber) {
		return randomNumber>3;
		//more than 4 : go, less than 3 : stop
	}
	void race() {
		int randomNumber;
		randomNumber = makeRandomNumber();
		if(decideGo(randomNumber)) {
			setPosition(getPosition()+1);
		}
	}
}
