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
	}
	
}
