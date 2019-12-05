package domain;

public class Game {

  IOController ioController = new IOController();
  Racing racing;

  public void play() {
    String[] carNames = {};
    int rounds;

    ioController.askCarsNames();
    carNames = ioController.getCarsNames();

    ioController.askRounds();
    rounds = ioController.getRounds();

    this.racing = new Racing(carNames, rounds);
    racing.start();

  }
}
