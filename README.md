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
1. 생성자 : Car를 생성한다.
2. getName() : Car.name의 getter.
3. getPosition() : Car.position의 getter.
4. tryMove() : 랜덤 정수(0~9)가 4 이상이면 앞으로 한칸 이동한다.
5. printPosition() : 자동차의 현재 위치를 출력한다.


# CarFactory
1. 생성자 : 자동차 이름을 입력받아 ","으로 split하여 저장한다.
2. makeCars() : 입력받은 자동차 이름을 바탕으로 Car[] Array를 생성하여 반환한다.
3. isValidName(String[] carNamesArray) : 입력받은 자동차 이름이 유효한지 판단한다. 

# RacingStation
1. getCarArray() : CarFactory 클래스의 makeCars() 메서드를 이용해 Car[] Array를 생성하여 저장한다
2. inputTryTimes() : 이동을 몇 번 시도할지 입력받는다.
3. moveCars() : Car[] Array의 자동차들을 각각 tryMove()한다
4. printSituation() : Car[] Array의 자동차들의 위치를 각각 출력한다.
5. startRace() : 입력 받은 이동 시도 횟수만큼 moveCar(), printSituation()한다.
6. getFirstPlaceIndex() : Car[] Array를 탐색하여 1등 중 제일 앞쪽에 있는 1등의 index를 리턴한다.
7. printWinners() : 우승자(공동 우승자 포함)를 출력한다.

# Main
1. playJavaRaincgCar() : 게임을 실행하는 메서드

주의 사항
------

* 함수의 길이가 15가 넘지 않도록 한다.
* else를 사용하지 않는다.
* 공동 우승에 주의하자.
* 자동차 이름은 5자 이하만 가능하다.