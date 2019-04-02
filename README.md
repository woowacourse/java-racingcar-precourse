# 자동차 경주 게임


### 설명
  * 주어진 횟수동안 n대의 자동차를 움직여 가장 멀리 이동한 자동차가 우승하는 게임이다

### 게임 진행 방식
  1. ","를 기준으로 n대의 자동차 이름을 입력한다
  2. 이동할 횟수를 입력한다
  3. 각 자동차마다 0~9의 랜덤 숫자를 생성하여 4이상일 경우 전진, 3이하일 경우에는 움직이지 않는다
  4. 3번의 과정을 이동 횟수만큼 반복한다
  5. 가장 멀리 이동한 자동차를 출력한다

### 프로그램 기능 구현 목록

* Main class
  * 프로그램 실행을 위한 main()


* Racing class
  * 자동차 이름을 입력 inputCarName()
  * 자동차 이름에 대해 올바른 입력인지 확인 isCorrectCarName()
  * 입력받은 이름으로 Car객체 생성 createCar()
  * 이동 횟수 입력 inputMovingNumber()
  * 게임 시작 runGame()
  * 이동 횟수만큼 Car객체에 대해 게임을 진행하고 상태 출력 startRacing()
  * 결과 출력 printResult()


* Car class
  * 랜덤 숫자에 대해 위치 갱신 updatePosition()
  * 랜덤 숫자 생성 getRandomNumber()
  * 현재 위치를 출력 printPosition()
  * 위치 반환 getPosition()
  * 이름 반환 getName()
