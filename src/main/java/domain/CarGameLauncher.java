package domain;

public class CarGameLauncher
{
    public static void main(String[] args)
    {
        doGame();
    }
    public static void doGame()
    {
        String[] carNames = Car.askCarNames();
        int turns = Car.askHowManyTurns();
        Car[] cars = Car.instantiateAndReturnCars(carNames);
        System.out.println();
        System.out.println("실행결과:");
        int turn = 0;
        while (turn < turns)
        {
            Car.updateCarMovements(cars);
            Car.printCarMovements(cars);
            System.out.println();
            turn++;
        }
        Car.announceWinners(cars);
        System.out.println();
        boolean wantOneMoreGame = Car.getUserAnswer();
        if(wantOneMoreGame)
        {
            doGame();
        }
    }
}
