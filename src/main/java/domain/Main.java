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
		
		ResultStick(number,cars);
		Winner(cars);	
	}
	
	public static void ResultStick(int number,Car[] cars) {
		System.out.println();
		System.out.println("실행 결과");
		
		for (int j=0; j<number; j++) {
			for (int i=0; i<cars.length; i++) {
				cars[i].MoveOrNot();
				cars[i].Visual();
			}
			System.out.println();
		}
	}
	
	public static void Winner(Car[] cars) {
		String name = "";
		int max = -1;
		for (int i=0; i<cars.length; i++) {
			
			if (cars[i].GetPosition() == max) {
				name = name +", "+cars[i].GetName();
			}
			if (cars[i].GetPosition() > max) {
				name = cars[i].GetName();
				max = cars[i].GetPosition();
			}
		}
		System.out.println(name+"가 최종 우승했습니다.");
	}
}
