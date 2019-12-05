package domain;

import java.util.Scanner;

public class IOController {

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
    for (int i = 0; i < names.length; i++) {
      if (names[i].length() == 0 || names[i].length() > 5) {
        return false;
      }
    }

    return true;
  }
}
