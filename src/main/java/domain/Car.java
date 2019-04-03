package domain;

public class Car {

  private final String name;
  private int position = 0;

  public Car(String name) {
    this.name = name;
  }

  // 추가 기능 구현
  public void movePos() {
    double randVal = Math.random();
    int intVal = (int) (randVal * 9);
    if (intVal > 3) {
      position++;
    }
  }

  public void showPos() {

  }
}
