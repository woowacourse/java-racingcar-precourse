package domain;

public class Game {

  Racing racing;

  public void play() {
    String[] carNames = {};
    int rounds;

    IOController.askCarsNames();
    carNames = IOController.getCarsNames();

    IOController.askRounds();
    rounds = IOController.getRounds();

    this.racing = new Racing(carNames, rounds);
    this.racing.start();

  }
}
