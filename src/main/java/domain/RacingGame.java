
package domain;
import java.util.Scanner;
public class RacingGame {
    public static Scanner sc = new Scanner(System.in);
    private String carUsers[] = InitCarName();  //자동차 입력
    private int testNumber = 0; //시도 횟수


    public RacingGame(String name) {
        this.name = name;
    }
    public static String[] InitCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String allCarNames = sc.nextLine();
		String carUsers[] = allCarNames.split(",");
        while (!isVaild(carUsers)) {
			System.out.println("5글자 초과. 다시 입력하세요.");
			allCarNames = sc.nextLine();
			carUsers = allCarNames.split(",");
		}
        return carUsers;
    }

    public static boolean isVaild(String[] carUsers){
        for(int i = 0; i<carUsers.length; i++){
            if(carUsers[i].length()>5){
                return false;
            }
        }
        return true;
    }

    public static void Game(Car[] cars){

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