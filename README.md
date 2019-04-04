## 자동차 경주

   기능 1. 사용자로부터 이름을 입력받은 후 각 이름에 해당하는 Car 클래스를 생성한다.

   기능 2. 사용자로부터 몇 번의 이동을 할 것인지 입력받는다.

   기능 3. 각 Car 객체의 전진/정지를 결정한다.

   기능 4. 경주 상황을 출력한다.

   기능 5. 우승자를 결정하고 출력한다.

class:
- public class Car

  method:

  - Car(String name)
    - 기본 생성자
  - goStop
    - 자동차의 전진을 결정
  - getPos
    - private position 값을 반환



- public class MainClass

  method:

  - main(String arg)
    - 메인 메소드
  - userInName
    - 사용자로부터 자동차의 이름을 입력받음
  - makeCar
    - 이름을 이용해 각각의 자동차 객체를 생성
  - userInMove
    - 사용자로부터 몇번의 이동을 할 것인지를 입력받음
  - doRace
    - 자동차 경주 시작
  - printRace
    - 매 번의 이동마다 경주 현황을 출력
  - selectWinner
    - 경주의 승리자를 찾아내는 메소드
  - printWinner
    - 승리자를 출력



