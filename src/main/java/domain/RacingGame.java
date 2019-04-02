package domain;

public class RacingGame {

    private void Start(){
        CarNameReciever carNameReciever = new CarNameReciever();
        CarGenerator carGenerator =new CarGenerator();
        RaceAttemptReciever raceAttemptReciever = new RaceAttemptReciever();
        CarRacer carRacer = new CarRacer();

        String[] carNames =carNameReciever.RecieveCarNamesFromUser();
        carGenerator.GenerateCar(carNames);
        raceAttemptReciever.RecieveRaceAttemptFromUser();

    }
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.Start();
    }
}

