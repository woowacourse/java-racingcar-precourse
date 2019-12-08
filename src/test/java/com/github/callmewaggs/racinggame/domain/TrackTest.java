package com.github.callmewaggs.racinggame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrackTest {
  @DisplayName("트랙은 입력받은 시행이 숫자일 경우 trial에 할당한다.")
  @Test
  public void create_track_when_input_trial_is_a_number() {
    // Arrange
    String inputCarNames = "short";
    String inputTrial = "50";

    // Act
    Track actual = new Track(inputCarNames, inputTrial);

    // Assert
    assertEquals(50, actual.getTrial());
  }
}
