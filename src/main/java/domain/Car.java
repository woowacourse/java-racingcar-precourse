package domain;

public class Car {
    private final String name;
    private int position = 0;
    private static final int minMovingDistance = 4;
    private int movingDistance;
    
    public Car(String name) {
        this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    
    public void randomMovingDistance() {
    	movingDistance = (int)(Math.random()*10);
    }
    
    public void increasePosition() {
    	if(movingDistance >= minMovingDistance) {
    		position++;
    	}
    }
    
    public void printMovingDistance() {
    	System.out.print(name+" : ");
    	for (int i=0; i<position; i++) {
    		System.out.print("-");
    	}
    	System.out.println();
    }
}
