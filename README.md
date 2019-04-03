#프리코스 2주차 미션 - 자동차 경주 게임.
---------------------------------------
* 우아한 테크코스 자동차 경주 게임을 구현하였습니다.  
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈추며, 자동차 게임을 완료한 후 누가
우승했는지 알려줍니다.

## 예시
```
경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)
pobi,crong,honux
시도할회수는몇회인가요?
5

실행결과
pobi:-
crong:-
honux:-

pobi:--
crong:-
honux:--

pobi:---
crong:--
honux:---

pobi:----
crong:---
honux:----

pobi:-----
crong:----
honux:-----

pobi,honux 가 최종 우승했습니다.
```

## 기능 리스트
1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
3. 자동차이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
4. 사용자는 몇번의 이동을 할 것인지를 입력할 수 있어야 한다.
5. 전진하는 조건은 0에서9사이에서 random값을 구한후 random값이 4이상일 경우 전진하고, 3이
하의 값이면 멈춘다.
6. 자동차 경주게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 기능별 모듈 분리
1. Car class
    1. public String getName()
        * 이름 반환 메서드.
    2. public int getPosition()
        * 위치 반환 메서드.
    3. public void moveForward(int)
        * 자동자 위치 이동 메서드.
2. Game class
    1. public void run()
        * 게임 순서 진행 메서드.
    2. private void settingCars()
        * 자동차들 셋팅 메서드.
    3. private String[] getNameByUser()
        * 자동차 이름을 유저로 부터 받아오는 메서드.
    4. private void makeCars(String[] carNames)
        * 자동차들 생성 메서드.
    5. private void settingGameCount()
        * 게임 횟수 셋팅 메서드.
    6. private int getGameCountByUser()
        * 게임 횟수를 유저로 부터 받아오는 메서드.
    7. private void carsRandomlyForward(List<Car> carList)
        * 랜덤하게 자동차들 이동 메서드.
    8. private boolean isCarForward()
        * 현재 자동차 이동 여부 확인 메서드.
    9. private int getRandomNumber()
        * 0-9 사이의 값 생성 메서드.
    10. private void printGameState()
        * 게임상태 프린트 메서드.
    11. private void printWinner()
        * 승자 프린트 메서드.
    12. private List<Car> getWinnerList()
        * 승자 리스트를 반환 메서드.
    13. private int getMaxCarPosition()
        * 가장 앞선 위치 반환 메서드
    
3. Valid interface
    1. public boolean validCarName(String[])
        * 자동차들 이름 검증 메서드.
    2. public boolean validGameCount(String)
        * 게임 횟수 검증 메서드.
        
4. UserInterface interface
    1. public String[] inputCarName()
        * 사용자로 부터, 자동차들 이름 입력 요청 메서드.
    2. public String inputGameCount()
        * 사용자로 부터, 게임횟수 입력 요청 메서드.
    3. public void alertInvalidCarName()
        * 유효하지 않은 자동차이름 알림 메서드.
    4. public void alertInvalidGameCount()
        * 유효하지 않은 게임횟수 알림 메서드.
    5. public void printGameState(List<Car> carList)
        * 게임 진행 상태 프린트 메서드.
    6. public void printWinner(List<Car> carList)
        * 게임 승자 프린트 메서드.















