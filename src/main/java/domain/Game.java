package domain;

public class Game {

  IOController ioController = new IOController();

  public void play() {
    String[] carNames = {};

    ioController.askCarsNames();
    carNames = ioController.getCarsNames();

    ioController.askRounds();
  }
}
