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
    public int creatRanNum() {
    	return (int) (Math.random() * 9 + 1);
    }
    
    public void carMove(int ranNum) {
    	if (ranNum >= 4) {
    		this.position++;
    	}
    }
    
    
}
