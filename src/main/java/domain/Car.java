package domain;

public class Car {
    private final String name;
    private int position = 0;

    
    public Car(String name) {
        this.name = name;
    }

	public String getName() {
		return name;
	}

    
    public void setPosition(boolean checkPosition) {
    	if(checkPosition)
    		position++;
    }

    public int getPosition() {
    	return position;
    }
}
