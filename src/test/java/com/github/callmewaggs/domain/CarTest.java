package com.github.callmewaggs.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

  @DisplayName("Car는 인자로 들어온 name의 길이가 5이하인 경우 name에 할당한다.")
  @Test
  public void create_car_when_its_name_under_five_letters() {
    // Arrange
    String name = "short";

    // Act
    Car actual = new Car(name);

    // Assert
    assertEquals("short", actual.getName());
  }

  @DisplayName("Car는 인자로 들어온 name의 길이가 5를 초과하는 경우 예외를 발생시킨다.")
  @Test
  public void throw_exception_when_cars_name_is_over_five_letters() {
    // Arrange
    String name = "too long name";

    // Act
    IllegalArgumentException actual =
        assertThrows(IllegalArgumentException.class, () -> new Car(name));

    // Assert
    assertEquals("자동차의 이름은 5글자 이하여야 합니다.", actual.getMessage());
  }
}
