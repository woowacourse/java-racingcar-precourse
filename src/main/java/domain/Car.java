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

    public String toString() {
    	return "-";
    }
    
    public void getPosition(boolean n) {
    	if(n)
    		position++;
    }
}
