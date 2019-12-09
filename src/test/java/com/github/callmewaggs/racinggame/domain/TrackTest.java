package com.github.callmewaggs.racinggame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
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

  @DisplayName("트랙은 입력받은 시행이 숫자가 아닐 경우 예외를 던진다.")
  @Test
  public void throw_exception_when_create_track_if_its_trial_argument_is_not_a_number() {
    // Arrange
    String inputCarNames = "short";
    String inputTrial = "not a number";

    // Act
    IllegalArgumentException actual =
        assertThrows(IllegalArgumentException.class, () -> new Track(inputCarNames, inputTrial));

    // Assert
    assertEquals("시도할 회수는 숫자여야 합니다.", actual.getMessage());
  }

  @DisplayName("트랙은 입력받은 자동차 이름들을 가지고 자동차를 준비시킨다.")
  @Test
  public void prepare_racing_cars_from_input_car_names() {
    // Arrange
    String inputCarNames = "test1,test2,test3";
    String inputTrial = "1";
    Track track = new Track(inputCarNames, inputTrial);

    // Act
    List<Car> actual = track.getRacingCars();

    // Assert
    assertEquals("test1", actual.get(0).getName());
    assertEquals("test2", actual.get(1).getName());
    assertEquals("test3", actual.get(2).getName());
  }

  @DisplayName("트랙에서는 입력받은 시행 회수만큼 race를 한다.")
  @Test
  public void race_racing_cars_using_trial() {
    // Arrange
    Track track = mock(Track.class);
    when(track.getRacingCars()).thenReturn(Arrays.asList(mock(Car.class), mock(Car.class)));

    // Act
    track.race();

    // Assert
    verify(track.getRacingCars().get(0), times(track.getTrial())).move(anyInt());
  }

  @DisplayName("트랙은 winner를 리턴한다.")
  @Test
  public void track_returns_winners() {
    // Arrange
    Track track = new Track("win1,win2,lose", "10");
    for (Car car : track.getRacingCars()) {
      if (car.getName().startsWith("win")) {
        car.move(9);
        continue;
      }
      car.move(1);
    }

    // Act
    List<Car> winners = track.getWinners();

    // Assert
    assertEquals("win1", winners.get(0).getName());
    assertEquals("win2", winners.get(1).getName());
  }
}
