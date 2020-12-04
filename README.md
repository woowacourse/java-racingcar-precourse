# 미션 - 자동차 경주 게임

## 💡 구현할 기능 목록
### 클래스 구현

1. ``Host`` : 전체적인 진행을 이끌기 위한 클래스
2. ``Race``  : 레이스를 진행하고 그 결과를 나타내는 클래스
3. ``MessageBox `` : 안내문구들을 가지고 있는 클래스
4. ``InputValidator`` : 입력 값 valid 여부를 체크하는 클래스
5. ``Car`` : 차 이름과 현재의 위치의 정보를 가지고 있는 클래스

***

### 메서드 구현

##### Host.java

1. ``start()`` : 입력 값을 받고 레이스를 시작해주는 메서드
2. ``inputCarNameAndProduceCar()`` : 차들의 이름을 입력 받고 차를 생성하는 과정을 담은 메서드
3. ``inputCarName()`` : 차들의 이름을 입력 받고 검증한 뒤 차 이름 배열을 리턴하는 메서드
4. ``inputAttemptNum()`` : 시도 횟수를 입력 받아 초기화 시키는 메서드
5. ``produceCar(String[] carNames)`` : 입력 받은 차들의 이름을 가지고 차를 추가하는 메서드
6. ``raceStart()`` : ``Race`` 클래스의 ``raceStart()`` 메서드를 호출하는 메서드

<br>

##### Race.java

1. ``raceStart()`` : 레이스의 전체적인 진행을 담당하는 메서드
2. ``carTryMove(Car car)`` : 랜덤 값으로 차량의 이동 여부를 결정 짓는 메서드
3. ``printCarCurrentLocation(Car car)`` : 차의 현재 위치를 출력해주는 메서드
4. ``winnerPrize()`` : 우승자를 출력해주는 메서드
5. ``getWinners()`` : 우승자를 파악하는 메서드

<br>

##### InputValidator.java

1. ``validateCarNames(String[] carNames)`` : 차 이름을 검증하는 메서드
2. ``validateAttemptNum(String attemptNum)`` : 시도 횟수를 검증하는 메서드

<br>

#####  Car.java

1. ``move()`` : position 값을 1 더하는 메서드
2. ``getName()`` : name 값을 리턴하는 메서드
3. ``getPosition()`` : position 값을 리턴하는 메서드
4. ``compareTo(Car c)`` : 정렬 시 기준을 잡기 위해 생성한 메서드
***
### 예외 상황

##### ``inputCarName()`` 

1. 자동차 이름이 입력되지 않았거나 공백이 입력된 경우

##### ``inputAttemptNum()``

1. 숫자가 아닌 다른 값이 입력된 경우
2. 숫자의 앞 뒤에 공백이 입력된 경우