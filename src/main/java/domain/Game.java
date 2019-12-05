package domain;

public class Game {

  IOController ioController = new IOController();

  public void play() {
    String[] carNames = {};
    int rounds;

    ioController.askCarsNames();
    carNames = ioController.getCarsNames();

    ioController.askRounds();
    rounds = ioController.getRounds();
  }
}
