### [자동차경주게임]
 자동차경주게임은 사용자로부터 자동차의 이름을(쉼표로 구분(,))입력받고 게임을 몇회 실시할건지 입력받아 실행되는 게임프로그램입니다.

#### [주요 Class]
1. RacingCar Class
* 게임을 실질적으로 구동하는 클래스

2. Car Class
* 게임에 필요한 Car를 정의하는 객체 클래스
    - String name : 자동차의 이름을 저장할 변수
    - int position : 자동차의 위치를 저장할 변수

3. Control Class
* 유저의 입력 part
    - 자동차의 이름 입력(userInputCarNames())
    - 게임 총 횟수 입력(userInputLimitTime())
* 게임 시작 part(gameStart())
    - 한 회에 수행되어야 할 과정을 수행(turnStart)
    - 한 회가 종료될 때 출력해야할 결과 출력(printTurn())
        + 출력 보조 함수(getWay())
* 게임 종료 part(gameEnd())
    - 우승 조건을 찾는 함수(가장 많이 움직인 횟수 찾기)(getMaxNum())
    - 우승 조건을 충족시킨 자동차를 찾아 출력하는 함수(getGameResult)