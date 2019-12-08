package com.github.callmewaggs.racinggame;

import static org.mockito.Matchers.any;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CarRacingGameTest {

  @DisplayName("게임을 시작하면 사용자에게 자동차 이름과 시행에 대한 입력을 받는다.")
  @Test
  public void get_user_input_when_game_start() {
    // Arrange
    CarRacingGame game = new CarRacingGame();

    // Act
    game.gameStart();

    // Assert
    assertEquals(any(), game.getInputCarNames());
    assertEquals(any(), game.getInputTrial());
  }
}
