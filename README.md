# java-racingcar-precourse

자동차 경주 게임 미션을 위한 저장소

## 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 프로그래밍 요구사항

### 객체

* 다음 Car 객체를 활용해 구현해야 한다.

* Car 기본 생성자를 추가할 수 없다.

* name, position 변수의 접근 제어자인 private을 변경할 수 없다.

* 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다

  ```java
  public class Car {
  	private final String name;
  	private int position = 0;
  
      public Car(String name) {
  		this.name = name;
  	}
  	// 추가 기능 구현
  }
  ```

* **3항 연산자를 쓰지 않는다.**

* **indent(인덴트,들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용**한다.

  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.

* **자바 코드 컨벤션을 지키면서 프로그래밍**한다.

  * https://naver.github.io/hackday-conventions-java/ : **좀 더 개선된 컨벤션 참고 문서**

* **함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.**

  * 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다

* **else 예약어를 쓰지 않는다.**

  * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  *  else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 구현할 기능 목록

1. 게임을 시작한다. (init())
2. 각 자동차의 이름을 받고(inputCarNames()), 쉼표를 기준으로 나눈 후 5자 이내인지 검사하고(verifyCarName()), Car 객체로 이루어진 ArrayList를 만든다. (enrollPlayers()).
3. 시행횟수(turnNumber)를 입력받는다.
4. turnNumber만큼 경주(race()) 한다. 이 때 Car 클래스의 각 인스턴스는 0부터 9까지의 수를 임의로 뽑아 4 이상이어야 전진(proceed())한다.
5. 시행횟수만큼 시행한 뒤 각 Car의 위치를 보고받아 (getPosition()) MAX값과 동일한 유저만큼 winner ArrayList에 넣는다.
6. 최종 우승자를 발표한다.(printWinner())

### 예외 처리

1. 입력받은 이름 길이가 5자가 넘거나, 쉼표를 연달아 입력해서 0자가 된 경우.
2. 입력받은 시행 횟수가 0 이하인 경우.
3. 입력받은 시행 횟수가 정수가 아닌 경우.