# 미션 - 자동차 경주 게임

## 💡 구현할 기능 목록
### 클래스 구현

1. ``Host`` : 전체적인 진행을 이끌기 위한 클래스
2. ``Race``  : 레이스를 진행하고 그 결과를 나타내는 클래스
3. ``MessageBox `` : 안내문구들을 가지고 있는 클래스
4. ``Checker`` : 입력 값 valid 여부를 체크하는 클래스

***

### 메서드 구현

##### Host.java

1. ``start()`` : 입력 값을 받고 레이스를 시작해주는 메서드
2. ``nameInput()`` : 차들의 이름을 입력 받는 메서드
3. ``attemptNumberInput()`` : 시도 횟수를 입력 받는 메서드
4. ``addCar(String[] carNames)`` : 입력 받은 차들의 이름을 가지고 차를 추가하는 메서드
5. ``raceStart()`` : ``Race`` 클래스의 ``raceStart()`` 메서드를 호출하는 메서드

<br>

##### Race.java

1. ``raceStart()`` : 레이스의 전체적인 진행을 담당하는 메서드
2. ``carTryMove(Car car)`` : 랜덤 값으로 차량의 이동 여부를 결정 짓는 메서드
3. ``printCarCurrentLocation(Car car)`` : 차의 현재 위치를 출력해주는 메서드
4. ``winnerPrize()`` : 우승자를 출력해주는 메서드
5. ``getWinners()`` : 우승자를 파악하는 메서드

<br>

##### Checker.java

