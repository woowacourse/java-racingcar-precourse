package baeminHW2;
import java.util.Random;

public class Car{
	private final String name;
	private int position =0;
	
	public Car(String name) {
		this.name = name;
	}
	
	public void goOrStop() {
		Random generator = new Random();
		int rand = generator.nextInt(9)+1;
		if(rand >4) {
			this.position++;
		}
		System.out.print(this.name + ":");
		for(int i=0; i<this.position; i++) {
			System.out.print("-");
		}
		System.out.print("\n");
	}
	
	public int getPosition() {
		return this.position;
	}
	
}