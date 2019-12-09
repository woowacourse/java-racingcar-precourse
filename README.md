:car: 자동차 경주 게임 :car:
============================

## 기능 요구 사항

* 입력 받은 횟수동안 n대의 자동차는 전진하거나 멈출 수 있음
* 각 자동차에 이름 부여 가능, 출력 시 자동차 이름과 함께 진행상황 출력
* 자동차 이름은 쉼표(,)로 구분하고 이름은 5자 이하만 가능
* 사용자는 입력 횟수를 입력 가능
* 0 - 9 사이의 random값을 구하고 4이상인 경우 전진, 아닌 경우 멈춤
* 게임 완료 후에는 우승자를 알려줘야 함

## 기능 목록

* Main 클래스 : 게임 생성, 게임 시작, 게임 종료

* Car 클래스 : Car의 속성과 행위를 가지고 있는 클래스
  * 생성자 : 자동차의 이름을 설정할 수 있는 메소드
  * getName() : 설정된 자동차의 이름을 가져오는 메소드
  * getPosition() : 이동거리를 가져오는 메소드
  * moveForward() : 자동차를 앞으로 전진시키는 메소드
  
* RacingCarGame 클래스 : 자동차 경주 게임 클래스
  * start() : 게임에 필요한 셋팅과 플레이를 시작하는 메소드
  * end() : 우승자를 가리고 종료하는 메소드
  * inputCars() : 사용자로부터 자동차 이름을 입력 받는 메소드
  * setCars() : 자동차 객체 생성 및 셋팅하는 메소드
  * inputGameCnt() : 사용자로부터 이동 횟수를 입력 받는 메소드
  * runRace() : 이동 횟수만큼 자동차를 움직이도록 지시하는 메소드
  * moveCar() : 자동차를 움직이고 결과를 출력하는 메소드
  * getNum() : 0 - 9까지 임의의 난수를 발생시키는 메소드
  * checkInputCars() : 사용자가 입력한 자동차의 유효성 유무를 체크하는 메소드
  * checkInputCnt() : 사용자가 입력한 이동 횟수의 유효성 유무를 체크하는 메소드
  * getMax() : 최대로 이동 거리를 구하는 메소드
  * getWinners() : 최종 우승자를 구하는 메소드
