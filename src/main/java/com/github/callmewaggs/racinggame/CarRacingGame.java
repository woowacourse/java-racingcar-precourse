package com.github.callmewaggs.racinggame;

import com.github.callmewaggs.racinggame.domain.Track;
import java.util.Scanner;

public class CarRacingGame {

  private String inputCarNames;
  private String inputTrial;

  public void gameStart() {
    Scanner scan = new Scanner(System.in);
    System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    this.inputCarNames = scan.nextLine();
    System.out.println("시도할 회수는 몇회인가요?");
    this.inputTrial = scan.nextLine();

    Track track = new Track(inputCarNames, inputTrial);
  }

  public String getInputCarNames() {
    return inputCarNames;
  }

  public String getInputTrial() {
    return inputTrial;
  }
}
