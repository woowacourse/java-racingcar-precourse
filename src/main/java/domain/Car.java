package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

	public void run() {
		int randomNumber = (int) (Math.random()*10);
    	if (randomNumber >= 4) {
    		position++;
    	}
	}

	public void printState() {
		StringBuffer sb = new StringBuffer();
    	
    	sb.append(name+" :");
    	for (int i = 0; i < position; i++) {
    		sb.append("-");
    	}
    	System.out.println(sb.toString());
	}

    public int getPosition() {
    	return position;
    }
}
