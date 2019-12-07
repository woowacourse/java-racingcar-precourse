public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void move() {
    	int num = (int)(Math.random()*10);
    	
    	if(num >= 4) {
    		position++;
    	}
    }
}
