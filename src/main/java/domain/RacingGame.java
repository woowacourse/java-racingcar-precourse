
package domain;
import java.util.Scanner;
public class RacingGame {
    public static Scanner sc = new Scanner(System.in);
    private final String name;
    private int position = 0;

    public RacingGame(String name) {
        this.name = name;
    }
    public static String[] InitCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String allCarNames = sc.nextLine();
		String carUsers[] = allCarNames.split(",");
        while (!isVaild(carUsers)) {
			System.out.println("자동차의 이름은 5글자 이하여야합니다. 다시 입력하세요.");
			allCarNames = sc.nextLine();
			carUsers = allCarNames.split(",");
		}
        return carUsers;
    }

    public static boolean isVaild(String[] carUsers){
        return true;
    }

    public static int Game(){
        return 0;
    }

    public static int EndGame(){
        return 0;
    }
}
/*
*RacingGame
    **InitCarName
        - 경주할 자동차 입력받음
        - "," 로 사용자 구분
    **isValid
        - 자동차 이름 유효성 판단
    **Game
        - 게임 실행
        - Car 클래스의 함수 호출
    **EndGame
        - 최종 출력 후 프로그램 종료
*/