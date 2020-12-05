package racingcar;

public class Racing_game {
	
	public Racing_game() {
		// TODO Auto-generated constructor stub
	}
	
	public void play_game(Car[] cars) {
		for (int i = 0; i < cars.length; i++) {
			cars[i].move_or_stop();
			cars[i].print_position();
		}
		System.out.println();
	}
	
	public void check_winner(Car[] car) {
		String Winners = "";
		int max = 0;
		for (int i = 0; i < car.length; i++) {
			if (car[i].get_position() > max) {
				max = car[i].get_position();
				Winners = car[i].get_name();
			}
			else if (car[i].get_position() == max) {
				Winners = Winners+", "+car[i].get_name();
			}
		}
		System.out.println("최종 우승자: "+Winners);
	}
}
