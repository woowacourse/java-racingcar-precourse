package com.github.callmewaggs.domain;

public class Car {

  private final String name;
  private int position = 0;

  public Car(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
    }
    this.name = name;
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }

  public void move(int randomNumber) {
    if (randomNumber >= 4) {
      ++position;
    }
  }
}
