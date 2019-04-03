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

1. Main class
  * main(): 프로그램 실행


2. Racing class
  * 게임 실행 runGame()
  * 입력
    * inputCarName(): 자동차 이름을 입력
    * isCorrectCarName(): 자동차 이름에 대해 올바른 입력인지 확인
    * createCar(): 입력받은 이름으로 Car객체 생성
    * inputMovingNumber(): 이동 횟수 입력
    * isCorrectMovingNumber(): 이동 횟수에 대해 올바른 입력인지 확인
  * 경주 시작
    * startRacing(): 이동 횟수만큼 Car객체에 대해 게임을 진행하고 상태 출력
  * 결과 출력
    * printResult(): 각 Car 객체당 position을 비교하여 최대값을 찾고, 가장 큰 position을 가진 Car 객체의 name을 출력


3. Car class
  * updatePosition(): 랜덤 숫자에 대해 위치 갱신
  * getRandomNumber(): 랜덤 숫자 생성
  * printPosition(): 현재 위치를 출력
  * getPosition(): 위치 반환
  * getName(): 이름 반환
