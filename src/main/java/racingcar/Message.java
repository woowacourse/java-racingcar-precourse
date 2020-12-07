package racingcar;

public class Message {
	public static void chooseCarName() { 
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		}
	
	public static void chooseRacingCount() { 
		System.out.println("시도할 회수는 몇회인가요?");
		}
	
	public static void executionResult() { 
		System.out.println("실행 결과");
		}
	
	public static void finalWinner(StringBuffer winner) { 
		System.out.print("최종 우승자: " + winner.substring(0, winner.length()-1));
		}
}
