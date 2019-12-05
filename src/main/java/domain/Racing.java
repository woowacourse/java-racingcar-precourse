package domain;

public class Racing {

  private Car[] cars;
  private int rounds;
  IOController ioController = new IOController();

  public Racing(String[] carNames, int rounds) {
    this.cars = new Car[carNames.length];

    for (int i = 0; i < carNames.length; i++) {
      Car newCar = new Car(carNames[i]);
      this.cars[i] = newCar;
    }

    this.rounds = rounds;
  }

  private int generateRandomNumber() {
    return (int) (Math.random() * 10);
  }

  private void moveCars() {
    for (int i = 0; i < this.cars.length; i++) {
      int number = generateRandomNumber();

      if (number >= 4) {
        this.cars[i].go();
      }
    }
  }

  private void raceOneRound() {
    moveCars();
  }

  public void start() {
    System.out.println("\n실행 결과");
    for (int i = 0; i < rounds; i++) {
      raceOneRound();
      ioController.printRoundResult(this.cars);
    }

  }


}
