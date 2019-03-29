package domain;

public class CarGameLauncher
{
    public static void main(String[] args)
    {
        doGame();
    }
    public static void doGame()
    {
        String[] carNames = Car.getCarNames();
        int turns = Car.askHowManyTurns();
    }

}
