# 미션 - 자동차 경주 게임

구현 순서 : 상수→멤버 변수→생성자→메서드

## Car

1. 매직넘버를 피하기 위한 상수가 필요. → 무작위 값의 범위를 정해주는 `MIN_CONDITION = 0, MAX_CONDITION = 0` 을 상수로 생성.

   → `Constant` 객체에 `static final` 선언하여 사용.

2. 현재 위치 `postition` 에 대한 정보를 `GameHandler` 에게 전해줄 메서드 → `currentPostition()`

3. 자동차가 전진하는 행위에 대한 method 생성. → `go()` 

   - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우

4.  `GameHandler` 가 자동차의 이름을 알 수 있게 하기 위해서 `name()` method 필요.

`domain` directory 에서 관리.

<br>

## GameHandler

1. 글자 수 최소, 최대 상수 필요  (`Constant` 객체에 추가)
2. 자동차들을 생성해야 함 → `createCars()`
3. 몇번의 이동을 할지 정해야 함. → `getStages()`
4. 이동횟수만큼 자동차들이 `go` 하게 만든다.
5. 매 이동횟수 때마다 결과를 보여줘야 한다. → `showEachStageResult()`
6. 이동이 모두 끝나면 각 자동차들의 현재위치 중 가장 큰 값을 가진 자동차들을 찾고 우승자로 나열한다. → `showWinners()`
   1. 현재 위치가 가장 먼 자동차의 위치를 찾는 함수
   2. 가장 먼 위치를 기준으로 같은 값을 가진 자동차가 있으면 우승자에 추가 후 출력형태로 만드는 함수
7. 위 method들을 하나의 프로세스로써 묶어줘야 함. → `run()` method 생성.
   1. `createCars()` → 알맞은 자동차 생성
   2. `getStages()` → 얼마나 이동할 것인지
   3. `executeStage()` → 이동횟수 만큼 아래의 프로세스를 실행 
      1. 각 자동차들 모두 `go`.
      2. 각 자동차들 현재 위치 출력. → `showEachStageResult()`
   4. 우승자 출력 →  `showWinners()`

`utils` directory 에서 관리.

<br>

## UserService

`GameHandler` 가 맡는 책임이 너무 많다고 판단. 일부분을 따로 Class로 분리시키기로 함.

1. GameHandler 하는 일

2. 1. 사용자 입력 받는 일
   2. 적절한 입력인지 검사하는 일
   3. 경주에 참여할 자동차 생성하는 일
   4. 자동차들을 이동횟수만큼 움직이는 일
   5. 각 stage마다 실행결과를 출력해주는 일
   6. 우승자를 선별하고 출력하는 일

1-1, 1-2 부분을 따로 분리시켜 `UserService` 라는 class 로 만들 것이다. `utils` directory 에서 관리.

### 생성할 기능 목록

1. 사용자 입력 받는 기능
   1. 자동차 이름 입력 받기 → `register()` : 자동차 이름을 등록하여 자동차 List return.
   2. 이동 횟수 입력 받기 → `howManyTimes()` : 이동횟수를 입력받고 적절하면 int type return.
2. 적절한 입력인지 검사하는 기능

<br>

## Verifier

1주차의 목표는 method의 분리. 이번 2주차의 목표는 Class의 분리이다. 따라서 UserService의 책임 중, '검증하는 기능'을 따로 분리하여 class로 구현할 것이다.

### 생성할 기능 목록

1. 이름이 올바른지 확인
   1. 글자 수 1~5 글자.
   2. 중복되면 안됨.
2. 이동 횟수가 올바른지 확인
   1. 숫자가 들어와야 함.
   2. 0이 아닌 양의 정수가 들어와야 함.

`utils` directory 에서 관리.

<br>

## Constant

1. `MIN_CONDITION` : Random 숫자 범위의 최솟값.(==0)
2. `MAX_CONDITION` : Random 숫자 범위의 최댓값.(==9)
3. `MIN_NAME_LENGTH` : 이름의 글자 수 최솟값.(==1)
4. `MAX_NAME_LENGTH` : 이름의 글자 수 최댓값.(==5)
5. `IMPROPER_CHARACTER`(=='`,`')
6. `SPLIT_STRING`(=="`,`")
7. `MOVING_FORWARD`: ==4. 차가 움직일 수 있는 조건의 최솟값
8. `MIN_STAGE_NUMBER` : 이동 횟수로 받을 수 있는 값의 최솟값. == 1
9. `INVALID_STAGE_NUMBER` : 적절하지 않은 이동 횟수. == -1
10. `EMPTY` : 빈 문자열 표시. == ""
11. `SPACE` : 띄워쓰기 문자열. == " "

<br>

<br>

## Message

1. `START` : "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
2. `ERROR_INVALID_NAME_FORMAT` : "[ERROR] 자동차의 이름은 중복없이 1~5글자 입니다"
3. `ASK_STAGES` : "시도할 회수는 몇회인가요?"
4. `ERROR_INVALID_STAGE_VALUE` : "[ERROR] 시도할 횟수는 숫자여야 합니다"
5. `EXECUTE_RESULT` : "실행 결과"
6. `WINNERS` : "최종 우승자 : "

