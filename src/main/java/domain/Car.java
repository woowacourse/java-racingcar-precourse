package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    public int getLocate() {
    	return this.position;
    }
    
    public String getName() {
    	return this.name;
    }
    public int createRanNum() {
    	return (int) (Math.random() * 9 + 1);
    }
    
    public void isCarMove(int ranNum) {
    	if (ranNum >= 4) {
    		this.position++;
    	}
    }
    public void oneRace() {
    	isCarMove(createRanNum());
    	RoundResult();
    }
    
    public void RoundResult() {
    	System.out.print(this.name + " : ");
    	for (int i = 0; i < this.position; i++) {
    		System.out.println("-");
    	}
    	System.out.println();
    }
    
    
}
