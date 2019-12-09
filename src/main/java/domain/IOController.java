package domain;

import java.util.Scanner;

public class IOController {

  public void askRounds() {
    System.out.println("시도할 횟수는 몇회인가요?");
  }

  public int getRounds() {
    try {
      int rounds;
      Scanner scanner = new Scanner(System.in);

      rounds = scanner.nextInt();

      if (rounds <= 0) {
        return getAgainRounds();
      }

      return rounds;

    } catch (Exception e) {
      return getAgainRounds();
    }
  }

  private void askAgainRounds() {
    System.out.println("0보다 큰 숫자로만 입력해주세요.");
  }

  private int getAgainRounds() {
    askAgainRounds();
    return getRounds();
  }

  public void askCarsNames() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
  }

  public String[] getCarsNames() {
    String userInput;
    String[] carNames = {};
    Scanner scanner = new Scanner(System.in);

    userInput = scanner.nextLine();

    carNames = parseNames(userInput);

    return carNames;
  }

  private void askAgainCarsNames() {
    System.out.println("다시 입력해주세요.(이름은 쉼표(,) 기준으로 구분, 5자 이하)");
  }

  private String[] getAgainCarsNames() {
    askAgainCarsNames();
    return getCarsNames();
  }

  private String[] parseNames(String input) {
    String[] carNames = {};

    carNames = input.split(",");

    boolean availability = validateName(carNames);

    if (!availability) {
      return getAgainCarsNames();
    }

    return carNames;
  }

  private boolean validateName(String[] names) {
    if (names.length == 0) {
      return false;
    }

    for (int i = 0; i < names.length; i++) {
      String name = names[i].trim();

      if (name.length() == 0 || name.length() > 5) {
        return false;
      }
    }

    return true;
  }

  private void printCurrentPosition(Car car) {
    for (int i = 0; i < car.getPosition(); i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  public void printRoundResult(Car[] cars) {
    for (int i = 0; i < cars.length; i++) {
      System.out.print(cars[i].getName() + " : ");
      printCurrentPosition(cars[i]);
    }
    System.out.println();
  }

  public void printWinner(String winner) {
    System.out.println(winner + "이(가) 최종 우승했습니다.");
  }
}
