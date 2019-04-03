### 우아한 테크코스 온라인 2주차
# 자동차 경주 게임

## 문제 설명
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.


## 구현할 기능
* __Car 클래스__
  * 자동차 이름 setter 함수
    * _setName()_
  * 자동차 이름 getter 함수
    * _getName()_
  * 자동차 위치 setter 함수
    * _setPosition()_
  * 자동차 위치 getter 함수
    * _getPosition()_
  * 자동차 상태 setter 함수
    * _setStatus()_
  * 자동차 상태 getter 함수
    * _getStatus()_

* __Race 클래스__
  * 레이스 실행
    * _doGame()_
  * 이름 조건 확인
    * _isNameValid()_
  * 우승자 리턴
    * _printWinner()_

* __Main 클래스__
  * 프로그램 실행
    * _main()_