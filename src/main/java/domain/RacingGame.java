package domain;

public class RacingGame {

    private void Start(){
        CarNameReciever carNameReciever = new CarNameReciever();
        CarGenerator carGenerator =new CarGenerator();
        RaceAttemptReciever raceAttemptReciever = new RaceAttemptReciever();
        CarNavigator carNavigator = new CarNavigator(carGenerator.getCarList());
        ResultPrinter resultPrinter = new ResultPrinter(carGenerator.getCarList());

        String[] carNames =carNameReciever.RecieveCarNamesFromUser();
        carGenerator.GenerateCar(carNames);
        int raceAttempt = raceAttemptReciever.RecieveRaceAttemptFromUser();
        carNavigator.MoveCars();
        resultPrinter.PrintAllResults(raceAttempt);

    }
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.Start();
    }
}

