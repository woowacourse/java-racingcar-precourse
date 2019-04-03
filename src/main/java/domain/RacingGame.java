package domain;

public class RacingGame {
    private CarNameReciever carNameReciever;
    private CarGenerator carGenerator;
    private RaceAttemptReciever raceAttemptReciever;
    private CarNavigator carNavigator;
    private RaceResultPrinter resultPrinter;

    public RacingGame() {
        carNameReciever = new CarNameReciever();
        carGenerator = new CarGenerator();
        raceAttemptReciever = new RaceAttemptReciever();
        carNavigator = new CarNavigator(carGenerator.getCarList());
        resultPrinter = new RaceResultPrinter(carGenerator.getCarList());
    }

    private void Start() {
        String[] carNames = carNameReciever.RecieveCarNamesFromUser();
        carGenerator.GenerateCar(carNames);
        int raceAttempt = raceAttemptReciever.RecieveRaceAttemptFromUser();
        this.MoveCarsAndPrintAllResults(raceAttempt);
    }

    private void MoveCarsAndPrintAllResults(int raceAttempt) {
        for (int i = 0; i < raceAttempt; i++) {
            carNavigator.MoveCars();
            resultPrinter.PrintEachRaceAttemptResult();
        }
        WinnerPrinter winnerPrinter = new WinnerPrinter(carGenerator.getCarList());
        winnerPrinter.PrintWinner();
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.Start();
    }
}

