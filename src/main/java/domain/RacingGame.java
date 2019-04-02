package domain;

public class RacingGame {

    private void Start(){
        CarNameReciever carNameReciever = new CarNameReciever();
        CarGenerator carGenerator =new CarGenerator();
        RaceAttemptReciever raceAttemptReciever = new RaceAttemptReciever();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        String[] carNames =carNameReciever.RecieveCarNamesFromUser();
        carGenerator.GenerateCar(carNames);
        raceAttemptReciever.RecieveRaceAttemptFromUser();
        randomNumberGenerator.GenerateRandomNumber();
    }
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.Start();
    }
}

