package domain;

public class Racing {

  private Car[] cars;
  private int rounds;

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
    for (int i = 0; i < cars.length; i++) {
      int number = generateRandomNumber();

      if (number >= 4) {
        cars[i].go();
      }
    }
  }

  private void raceOneRound() {
    moveCars();
  }

  public void start() {
    for (int i = 0; i < rounds; i++) {
      raceOneRound();
    }

  }


}
