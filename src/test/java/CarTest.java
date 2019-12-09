import java.util.Scanner;
import java.util.Vector;

public class CarTest {
	
	static void showWinners(Vector <String> winners) {
		int winnersCnt;
		
		winnersCnt = winners.size();
		System.out.println(winners.size());
		
		for( int i=0 ; i<winnersCnt-1; i++) {
			System.out.print(winners.get(i) + ", ");
		}
		
		System.out.println(winners.lastElement() + "가 최종 우승했습니다.");
	}
	
	static void getWinners(Vector <Car> carNames, int Max) {
		Vector <String> winners = new Vector <String>();
		int position;
		int carCnt = carNames.size();
		
		for( int i=0 ; i<carCnt ; i++) {
			Car car = carNames.get(i);
			position = car.getPosition();
			if(Max == position) {
				winners.add(car.getName());
			}
		}
		
		showWinners(winners);
	}
	
	static int getMax(Vector <Car> carNames) {
		int carCnt = carNames.size();
		int Max = 0;
		int position;
		
		for( int i=0 ; i<carCnt ; i++ ) {
			Car car = carNames.get(i);
			position = car.getPosition();
			
			if(Max < position) {
				Max = position;
			}
		}
		
		return Max;
	}
	
	static void moveCars(Vector <Car> carNames) {
		int carCnt = carNames.size();
		
		for( int i=0 ; i<carCnt ; i++ ) {
			Car car = carNames.get(i);
			car.move();
			car.showName();
			car.showPosition();
			carNames.setElementAt(car, i);
			System.out.println();
		}
	}
	
	static void showResult(Vector <Car> carNames, int tryCnt) {
		int Max = 0;
		
		System.out.println("실행결과");
		for( int i=0 ; i<tryCnt ; i++ ) {
			moveCars(carNames);
			System.out.println();
		}
		
		Max = getMax(carNames);
		
		getWinners(carNames, Max);
	}
	
	static int getTrycnt() {
		Scanner scanner = new Scanner(System.in);
		int input;
		
		System.out.println("시도할 회수는 몇회인가요?");
		input = scanner.nextInt();
		
		return input;
	}
	
	static void initRace(Vector <Car> carNames) {
		int tryCnt;
		int carCnt;
		
		carCnt = carNames.size();
		
		for( int i=0 ; i<carNames.size() ; i++) {
			Car car = carNames.get(i);
			String name = car.getName();
			System.out.println(name);
		}
		
		
		tryCnt = getTrycnt();
		
		showResult(carNames, tryCnt);
		
	}
	
	static void makeCars(Vector <Car> carNames) {
		int nameCnt;
		String names;
		String[] cars;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,)기준으로 구분)");
		names = scanner.nextLine();
		
		cars = names.split(",");
		nameCnt = cars.length;
		System.out.println(nameCnt);
		for( String name : cars) {
			if(name.length() <= 5) {
				Car car = new Car(name);
				carNames.add(car);
			}
		}
	}

	public static void main(String[] args) {
		
		Vector <Car> carNames = new Vector <Car>();
		
		makeCars(carNames);
		System.out.println(carNames.size());
		initRace(carNames);
	}

}
