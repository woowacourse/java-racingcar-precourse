package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

	public void run() {
		int randomNumber = (int) (Math.random()*10);
    	if (randomNumber >= 4) {
    		position++;
    	}
	}

    
}
