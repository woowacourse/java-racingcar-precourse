- 2019.12.04
- 우아한테크코스 프리코스2주차
- 자동차 경주 게임
-------------------------
# 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이
하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
-------------------------
# car
- variable
  - name
  - position
- method
  - getCarName
  - getPosition
  - move
# gameMc
- variable
  - userInput
  - round
  - ArrayList<Car> carList
- method
  - isOverFiveWords
  - input
  - gameStart
    - Input car name
    - Input round
  - setCarList
  - gameProcess
    - GenerateRanNum
    - moveOrStay
    - broadcast
  - awarding
    - scoring

--------------
# 예외
- [x] 시도할 회수 입력시 0 또는 숫자가 아닌 문자 입력