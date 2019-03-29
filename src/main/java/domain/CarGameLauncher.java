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
        Car[] cars = Car.instantiateAndReturn(carNames);
        System.out.println();
        System.out.println("실행결과:");
        int i = 0;
        while (i < turns)
        {
            Car.moveCars(cars);
            Car.printMovements(cars);
            System.out.println();
            i++;
        }
        Car.announceWinners(cars);
        boolean wantOneMoreGame = Car.getUserAnswer();
        if(wantOneMoreGame)
        {
            doGame();
        }
    }
}
