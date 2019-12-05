package domain;

public class Game {

  IOController ioController = new IOController();

  public void play() {
    ioController.askCarsNames();
  }
}
