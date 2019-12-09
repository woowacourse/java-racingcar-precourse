import com.woowahan.racingcar.Race;
import com.woowahan.racingcar.User;

public class Main {
	public static void main(String[] args) {
		User user = new User();
		user.input();

		Race race = new Race(user);
		race.start();
	}
}
