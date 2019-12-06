package domain;

public class Car {
	private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    public void MoveOrNot() {
    	int num = Random_Number();
    	if (num >= 4) {
    		position += 1;
    	}
    }
    
    public int Random_Number() {
    	int random_number = (int) (Math.random() * 10);
    	return random_number;
    }
    
    public void Visual() {
    	System.out.print(name+" : ");
    	for (int i=0; i<position; i++) {
    		System.out.print("-");
    	}
    	System.out.println();
    }
    
    public int GetPosition() {
    	return position;
    }
    
    public String GetName() {
    	return name;
    }
}