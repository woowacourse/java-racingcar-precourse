# 2주차 미션 - 자동차 경주 게임
## 기능 요구사항
1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
3. 자동차 이름은 쉼표(,)를 기준으로 구분하여 이름은 5자 이하만 가능하다.
4. 사용자는 몇번의 이동을 할 것인지를 입력할 수 있어야 한다.
5. 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3이하의 값이면 멈춘다.
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
## 기능 목록

### Main class
게임을 실행하는 클래스
- 게임 시작 기능 구현
- 입력 받은 시도 횟수 만큼 레이싱을 실행하는 기능 구현

### Car class
자동차의 이름, 위치, 자동차의 주행을 관리하는 클래스
- 랜덤 값을 생성하는 randomNumGenerator 함수 구현
- 3에서 생성한 값에따라 자동차를 이동시키는 goAndStop 함수 구현
- 자동차가 이동한 정도를 출력하는 printDistance  함수 구현

### Gameplay class
게임을 진행하는데 필요한 함수들을 가지고 있는 클래스
- 자동차의 이름을 입력 받는 setCarName 함수 구현
- 시도 횟수를 입력 받는 setRoundNum 함수 구현
- 사용자에게 자동차의 이름과 시도할 회수를 입력받는 initSetup 함수 구현
- 자동차 객체를 생성하는 createCar 함수 구현
- 각 자동차마다 게임을 실행하고 출력해주는 doRace 함수 구현
- 게임의 결과를 출력하는 checkWinner 함수 구현