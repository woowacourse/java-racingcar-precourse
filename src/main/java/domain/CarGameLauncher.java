package domain;

public class CarGameLauncher
{
    public static void main(String[] args)
    {
        doGame();
    }

    public static void doGame()
    {
        Car[] cars = prepareGame();
        playGame(cars);
        endGame(cars);
    }

    public static Car[] prepareGame()
    {
        String[] carNames = Car.askCarNames();
        Car[] cars = Car.instantiateAndReturnCars(carNames);
        return cars;
    }

    public static void playGame(Car[] cars)
    {
        int turns = Car.askHowManyTurns();
        int turn = 0;
        System.out.println();
        System.out.println("실행결과:");
        while (turn < turns)
        {
            Car.updateCarMovements(cars);
            Car.printCarMovements(cars);
            System.out.println();
            turn++;
        }
    }

    public static void endGame(Car[] cars)
    {
        Car.announceWinners(cars);
        System.out.println();
        boolean wantOneMoreGame = Car.getUserAnswer();
        if(wantOneMoreGame)
        {
            doGame();
        }
    }
}
