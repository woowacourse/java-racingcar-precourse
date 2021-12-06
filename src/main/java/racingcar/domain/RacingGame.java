package racingcar.domain;

public class RacingGame {
	private static final RacingGame racingGame = new RacingGame();
	// 메인로직에 사용되는 insert될 객채(혹은 list), 혹은 결과값(을 뽑아낼 수있음 생략) 변수와 객체를, 싱글톤이 관리.
	//TODO singleton1)  외부에서 관리자가 메인로직을 실행할 때, << 필요한 값을 받아 함수를 만드는데 >>>

	private RacingGame() {
	}

	public static RacingGame getInstance() {
		return racingGame;
	}

	// TODO singleton2) 메서드에 필요 -> 관리변수 -> 매 로직시마다 초기화도 가능하도록 한다.
	public void init() {
		// TODO: 로직용 관리할 변수, 결과변수 생길시마다 초기화넣어주기
	}

	//TODO: 관리할 변수는, 메서드 생성과 함께 파라미터로 들어오니 -> 관리변수로 생성하기
}
