package racingcar;

public class Application {
    public static void main(String[] args) {
        try {
            RaceController race = new RaceController();

            race.racing();
            race.awarding();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
