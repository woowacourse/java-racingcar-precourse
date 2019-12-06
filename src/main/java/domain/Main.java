package domain;


public class Main {
	public static void main (String[] args) {
		User user = new User();
		
		String[] names = user.EnterCarName_ReturnArray();
		Car[] cars = new Car[names.length];
		int number = user.Attempt();
		
		for (int i=0; i<names.length; i++) {
			Car car = new Car(names[i]);
			cars[i] = car;
		}
		
		for (int j=0; j<number; j++) {
			for (int i=0; i<cars.length; i++) {
				cars[i].MoveOrNot();
				cars[i].Visual();
			}
		}
		
		
		
	}
}
