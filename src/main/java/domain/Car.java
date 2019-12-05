package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void forward() {
    	this.position++;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public int getPos() {
    	return this.position;
    }
    
    public void printPos() {
    	System.out.print(name + ": ");
    	for(int i=0; i<this.position; i++) {
    		System.out.print("-");
    	}
    	System.out.println();
    }
}
