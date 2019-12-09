import java.util.Scanner;

public class CarTest {

	public static void main(String[] args) {
		
		String names;
		String[] cars;
		String[] winners = {null,};
		int nameCnt;
		int carCnt = 0;
		int tryCnt;
		int winnerCnt = 0;
		int Max = 0;
		int position;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,)기준으로 구분)");
		names = scanner.nextLine();
		
		cars = names.split(",");
		nameCnt = cars.length;
		System.out.println(nameCnt);
		Car[] carNames = new Car[nameCnt];
		
		for( String name : cars) {
			if(name.length() <= 5) {
				carNames[carCnt++] = new Car(name);
				System.out.println(name);
			}
		}
		
		System.out.println("시도할 회수는 몇회인가요?");
		tryCnt = scanner.nextInt();
		System.out.println();
		
		System.out.println("실행결과");
		for( int i=0 ; i<tryCnt ; i++ ) {
			for( int j=0 ; j<carCnt ; j++ ) {
				carNames[j].move();
				carNames[j].showName();
				carNames[j].showPosition();
				System.out.println();
			}
			System.out.println();
		}
		
		for( int i=0 ; i<carCnt ; i++ ) {
			position = carNames[i].getPosition();
			if(Max < position) {
				Max = position;
			}
		}
		
		for( int i=0 ; i<carCnt ; i++) {
			position = carNames[i].getPosition();
			if(Max == position) {
				winners[winnerCnt++] = carNames[i].getName();
			}
		}
		
		for( int i=0 ; i<winnerCnt-1; i++) {
			System.out.print(winners[i] + ", ");
		}
		
		System.out.println(winners[winnerCnt-1] + "가 최종 우승했습니다.");
		
	}

}
