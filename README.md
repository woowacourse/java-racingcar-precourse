2주차 미션 - 자동차 경주 게임🚗
=======================

###프로그래밍 요구사항

1. 자바 코드 컨벤션을 지키면서 프로그래밍한다.
2. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    + 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다. 
    + 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
3. 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    + 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
4. else 예약어를 쓰지 않는다.
    + 힌트 : if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    + else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
5. 객체
    + 다음 Car 객체를 활용해 구현해야 한다.
    + Car 기본 생성자를 추가할 수 없다.
    + name, position 변수의 접근 제어자인 private을 변경할 수 없다.
    + 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.

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


###기능 요구사항

1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
5. 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. 

###기능 정리
+ Car
    + getName() : 객체의 name값을 반환 한다.
    + getPosition() : 객체의 position값을 반환 한다.
    + move() : position값을 변경한다.
    + checkNameSize() : 객체 생성시 name값이 유효한지 검사 한다.
+ Game
    + play() : 게임 실행   
    + round() : 라운드 진행
    + moveOrNot() : car 객체의 position을 변경할지 정한다.
    + endGame() : 게임을 종료하며 결과 List를 넘겨 준다.
+ GameService
    + getCars() : Console에서 입력 받은 car의 이름을 받는다.
    + makeCarList() : 입력 받은 car의 이름으로 객체를 생성하고 List로 변환한다
    + getRoundCount() : Console에서 입력 받은 round횟수를 넘겨 받는다.
    + setRoundResult() : round 결과값을 반환한다.
    + makeWinnerList() : List에서 position이 가장 큰 객체들만 남기고 나머지를 모두 삭제한다.
    + maxPosition() : List의 객체 중 가장 큰 position값을 가지고 온다.
+ Console
    + writeStartMessage() : 게임 시작 메세지 출력한다.
    + readCars() : 사용자에게 car들의 이름을 입력 받는다.
    + writeRoundMessage() : 라운드 횟수를 입력 받기 위해 출력한다.
    + readRoundCount() : 사용자에게 라운드 횟수를 입력 받는다.
    + writeRoundResult() : 라운드의 결과를 출력한다.
    + positionMessage() : position 값을 받아 "-"로 변환 한다.
    + writeGameResult() : 게임의 결과(승자)를 출력한다.