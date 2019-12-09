package domain;

public class Car {
	//띄어쓰기 컨벤션 체크하자. Space인지, tab인지
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

	public String getName() {
		return name;
	}
	
    public int getPosition() {
    	return this.position;
    }
    
    public void addPosition() {
    	this.position += 1;
    }
    
    //Car class test
    public static void main(String[] args) {
//		Car test1 = new Car("asdf");
//		System.out.println(test1.getName());
//		System.out.println(test1.getPosition());
//		test1.addPosition();
//		System.out.println(test1.getPosition());
//		
		Car asdf = new Car("asdf");
		Car qwer = new Car("qwer");
		Car[] carArray = {asdf, qwer};
		for (int i = 0; i < carArray.length; i++) {
			carArray[i].addPosition();
			System.out.println(carArray[i].getName() + carArray[i].getPosition());
		}
	}
}
