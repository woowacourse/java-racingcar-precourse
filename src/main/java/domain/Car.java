package domain;

public class Car {
	public static int carNum;
	public static int maxPosition=0;
	
    private final String name;
    private int position = 0;
 

    public Car(String name) {
        this.name = name;
    }
    
    public void bringRandomNumberMovePosition() {
    	int randomNumber = (int)(Math.random()*10);
    	
    	if (randomNumber >= 4) {
    		this.position++;
    		
    		if(Car.maxPosition == this.position) {
    			Car.maxPosition = position;
    		}
    	}
    }
    
    public void printResult() {
    	System.out.print(this.name + " : ");
    	
    	for (int i = 0; i<this.position; ++i) {
    		System.out.print("-");
    	}
    	System.out.println();
    }

   
}
