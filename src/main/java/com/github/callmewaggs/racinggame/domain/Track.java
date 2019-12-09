package com.github.callmewaggs.racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Track {

  private List<Car> racingCars;
  private int trial;

  public Track(String inputCarNames, String inputTrial) {
    prepareCars(inputCarNames);
    prepareTrial(inputTrial);
  }

  private void prepareCars(String inputCarNames) {
    String[] parsed = inputCarNames.split(",");
    this.racingCars = new ArrayList<>();
    for (String name : parsed) {
      racingCars.add(new Car(name));
    }
  }

  private void prepareTrial(String inputTrial) {
    try {
      this.trial = Integer.parseInt(inputTrial);
    } catch (Exception e) {
      throw new IllegalArgumentException("시도할 회수는 숫자여야 합니다.");
    }
  }

  public List<Car> getRacingCars() {
    return racingCars;
  }

  public int getTrial() {
    return trial;
  }

  public void race() {
    for (int i = 0; i < trial; ++i) {
      raceCars();
      printCars();
    }
  }

  private void printCars() {
    for (Car car : racingCars) {
      System.out.print(car.getName() + " : ");
      for (int i = 0; i < car.getPosition(); ++i) {
        System.out.print("-");
      }
      System.out.println();
    }
    System.out.println();
  }

  private void raceCars() {
    for (Car car : racingCars) {
      int randomNumber = (int) (Math.random() * 1000) % 10;
      car.move(randomNumber);
    }
  }

  public List<Car> getWinners() {
    racingCars.sort((car1, car2) -> car2.getPosition() - car1.getPosition());

    List<Car> winners = new ArrayList<>();
    int winnerPosition = racingCars.get(0).getPosition();
    for (Car racingCar : racingCars) {
      if (winnerPosition == racingCar.getPosition()) {
        winners.add(racingCar);
      }
    }
    return winners;
  }
}
