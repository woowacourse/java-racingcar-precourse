import domain.InputManager;
import domain.RacingStadium;

public class RacingGame {
    public static void main(String[] args) {
        String[] participants = InputManager.getCarNames();
        int moveCount = InputManager.getMoveCount();

        RacingStadium racingStadium = new RacingStadium(participants, moveCount);
        racingStadium.startRace();
        racingStadium.announceWinners();
    }
}
