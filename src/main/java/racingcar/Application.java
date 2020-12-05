package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        
        String Players;
        String[] player_name;
        Car[] car = null;
        int try_num;
        Racing_game game = new Racing_game();
        
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Players = scanner.next();
        player_name = Players.split(",");
        
        for (int i = 0; i < player_name.length; i++) {
        	System.out.println(player_name[i]);
			car[i] = new Car(player_name[i]);
		}
        
        System.out.println("시도할 회수는 몇회인가요?");
        try_num = scanner.nextInt();
        
        System.out.println("실행 결과");
        for (int i = 0; i < try_num; i++) {
			game.play_game(car);
		}
    }
}
