package com.github.callmewaggs.racinggame;

import com.github.callmewaggs.racinggame.domain.Car;
import com.github.callmewaggs.racinggame.domain.Track;
import java.util.Scanner;

public class CarRacingGame {

  private String inputCarNames;
  private String inputTrial;

  public void gameStart() {
    Track track = prepareTrack();
    startRace(track);
    printWinners(track);
  }

  private Track prepareTrack() {
    Track track;
    while (true) {
      try {
        getUserInput();
        track = new Track(inputCarNames, inputTrial);
        break;
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    return track;
  }

  private void startRace(Track track) {
    System.out.println("\n실행 결과");
    track.race();
  }

  private void printWinners(Track track) {
    String winners = "";
    for (Car winner : track.getWinners()) {
      winners += winner.getName() + ", ";
    }
    System.out.println(winners.substring(0, winners.length() - 2) + "가 최종 우승했습니다.");
  }

  private void getUserInput() {
    Scanner scan = new Scanner(System.in);
    System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    this.inputCarNames = scan.nextLine();
    System.out.println("시도할 회수는 몇회인가요?");
    this.inputTrial = scan.nextLine();
  }
}
