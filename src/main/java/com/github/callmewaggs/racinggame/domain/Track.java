package com.github.callmewaggs.racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Track {

  private List<Car> racingCars;
  private int trial;

  public Track(String inputCarNames, String inputTrial) {
    this.racingCars = prepareCars(inputCarNames);
    this.trial = prepareTrial(inputTrial);
  }

  private List<Car> prepareCars(String inputCarNames) {
    String[] parsed = inputCarNames.split(",");
    List<Car> cars = new ArrayList<>();
    for (String name : parsed) {
      cars.add(new Car(name));
    }
    return cars;
  }

  private int prepareTrial(String inputTrial) {
    return Integer.parseInt(inputTrial);
  }

  public List<Car> getRacingCars() {
    return racingCars;
  }

  public int getTrial() {
    return trial;
  }
}
