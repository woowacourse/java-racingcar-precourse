package racingcar;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        
        String Players;
        String[] player_name;        
        int try_num;
        Racing_game game = new Racing_game();
        
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Players = scanner.next();
        player_name = Players.split(",");
        Car[] car = new Car[player_name.length];
        
        for (int i = 0; i < player_name.length; i++) {        	
			car[i] = new Car(player_name[i]);
		}
        
        System.out.println("시도할 회수는 몇회인가요?");
        try {
        	try_num = scanner.nextInt();
        }catch(NumberFormatException e) {
        	System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
        	try_num=0;
        }
        
        System.out.println("\n실행 결과");
        for (int i = 0; i < try_num; i++) {
			game.play_game(car);			
		}
        game.check_winner(car);
    }
}
