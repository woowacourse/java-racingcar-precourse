package domain;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}
	
	public void isGoStop(int n) {
	    if(n>=4) {
		this.position+=1;
	    }
	}

}