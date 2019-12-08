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
    for (Car car : racingCars) {
      int randomNumber = (int) (Math.random() * 1000) % 10;
      car.move(randomNumber);
    }
  }
}
