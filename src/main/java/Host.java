import model.Car;
import strategy.RacingCarWinnerStrategy;
import strategy.WinnerStrategy;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Host {
    private OutputView outputView;
    private WinnerStrategy<Car> judgement = new RacingCarWinnerStrategy();
    private List<Car> participants = new ArrayList<>();
    private int currentRound = 0;

    public Host(OutputView outputView) {
        this.outputView = outputView;
    }

    public void addParticipants(List<String> names) {
        names.forEach(name -> participants.add(new Car(name)));
    }

    public void startGame(int count) {
        outputView.printTitle();
        judgement.setParticipants(participants);

        while (currentRound < count) {
            progressRound();
            outputView.printCurrentRound(participants);
        }
        outputView.printWinners(judgement.getWinners());
    }

    private void progressRound() {
        participants.forEach(Car::tryMoving);
        currentRound++;
    }
}
