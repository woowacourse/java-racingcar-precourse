package domain;

public class Racing {

  private Car[] cars;
  private int rounds;
  private String winner = "";
  private int positionOfWinner = 0;

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

  private void setWinner(Car car) {
    int position = car.getPosition();

    if (position > this.positionOfWinner) {
      this.positionOfWinner = position;
      this.winner = car.getName() + ", ";
      return;
    }

    this.winner += car.getName() + ", ";
  }

  private void defineWinner() {
    for (int i = 0; i < this.cars.length; i++) {
      int currentPosition = this.cars[i].getPosition();
      if (currentPosition >= this.positionOfWinner) {
        setWinner(this.cars[i]);
      }
    }
    this.winner = this.winner.substring(0, this.winner.length() - 2);
  }

  private void raceOneRound() {
    moveCars();
  }

  public void start() {
    System.out.println("\n실행 결과");
    for (int i = 0; i < rounds; i++) {
      raceOneRound();
      IOController.printRoundResult(this.cars);
    }

    defineWinner();
    IOController.printWinner(this.winner);
  }


}
