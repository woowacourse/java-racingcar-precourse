package domain;

public class Main {
	public static void main (String[] args) {
		Car car = new Car("name");
		User user = new User();
		
//		car.Move(1);
//		System.out.print(car.Position());
		
		String[] names = user.EnterCarName_ReturnArray();
		int number = user.Attempt();
		
		for (int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
		System.out.print(number);
		
	}
}
