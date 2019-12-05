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



}
