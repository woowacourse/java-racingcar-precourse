package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void move() {
    	int num = (int)(Math.random() * 10);
    	
    	if (num >= 4) {
    		position++;
    	}
    }
	
    public void showName() {
    	System.out.print(name + " : ");
    }
    
    public void showPosition() {
    	for(int i = 0; i < position; i++) {
    		System.out.print("-");
    	}
    }
    
    public int getPosition() {
    	return position;
    }
    
    public String getName() {
    	return name;
    }
}
