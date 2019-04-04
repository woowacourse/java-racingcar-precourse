java-racingcar
==============

기능 실행 순서
----------

1. 자동차의 이름을 입력받아 ","로 구분하여 자동차를 생성한다.
2. 자동차를 몇 번(N) 이동시킬지 입력받는다.
3. 자동차를 이동시키고 결과를 출력한다.
4. 3번 과정을 총 N회 반복한다.
5. 우승자를 출력한다.

클래스 별 보유 기능
-------------
# Car
1. 생성자
2. tryMove()

# CarFactory
1. 생성자
2. makeCars()
3. isValidName() 

# RacingStation

주의 사항
------

* 함수의 길이가 15가 넘지 않도록 한다.
* else를 사용하지 않는다.
* 공동 우승에 주의하자.
* 자동차 이름은 5자 이하만 가능하다.