package com.github.callmewaggs.racinggame.domain;

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
  public void throw_exception_when_create_car_if_its_argument_name_is_over_five_letters() {
    // Arrange
    String name = "too long name";

    // Act
    IllegalArgumentException actual =
        assertThrows(IllegalArgumentException.class, () -> new Car(name));

    // Assert
    assertEquals("자동차의 이름은 5글자 이하여야 합니다.", actual.getMessage());
  }

  @DisplayName("Car는 생성시 position의 값이 0이다.")
  @Test
  public void create_car_with_zero_position() {
    // Arrange
    String name = "test";

    // Act
    Car actual = new Car(name);

    // Assert
    assertEquals(0, actual.getPosition());
  }

  @DisplayName("Car는 random number의 값이 4 이상일 경우, position의 값을 1 증가시킨다.")
  @Test
  public void car_increase_position_when_random_number_over_four() {
    // Arrange
    Car car = new Car("test");

    // Act
    car.move(9);

    // Assert
    assertEquals(1, car.getPosition());
  }

  @DisplayName("Car는 random number의 값이 4 미만일 경우, 움직이지 않는다.")
  @Test
  public void car_do_not_move_when_random_number_less_than_four() {
    // Arrange
    Car car = new Car("test");

    // Act
    car.move(3);

    // Assert
    assertEquals(0, car.getPosition());
  }

}
