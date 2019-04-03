import domain.RacingCarGame;

public class RacingCar {
    public static void main(String[] args) {
        final String carNamesWithComma = UserInterface.getCarNamesWithComma();
        final int remainingPlayCount = UserInterface.getRemainingPlayCount();

        RacingCarGame racingCarGame = RacingCarGame.of(carNamesWithComma, remainingPlayCount);
        racingCarGame.play();
        UserInterface.printRecords(racingCarGame.getRecorder());
        UserInterface.printWinners(racingCarGame.getWinners());
    }
}
