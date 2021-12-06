# 미션 - 자동차 경주 게임

구현 순서 : 상수→멤버 변수→생성자→메서드

## Car

1. 현재 위치 `postition` 에 대한 정보를 반환해줄 메서드 필요.
2. 자동차가 전진하는 행위에 대한 method 생성. → `go()` 
   - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우
3. 자동차 이름을 반환하는 기능 필요.

`domain` package 에서 관리.

<br>

## GameHandler

1. 게임 진행 과정을 하나의 프로세스로써 묶어줘야 함. → `run()` method 생성.
   1. 자동차 받아오기
   2. 이동횟수 받아오기
   3. `executeStage()` → 이동횟수 만큼 아래의 프로세스를 실행 
      1. 각 자동차들 모두 움직이게 하기.
      2. 각 자동차들 현재 위치 출력. 
   4. 우승자 출력 →  `showWinners()`

<br>

## UserInputService

`GameHandler` 가 맡는 책임이 너무 많다고 판단. 일부분을 따로 Class로 분리시키기로 함.

### 생성할 기능 목록

1. 사용자 입력 받는 기능
   1. 자동차 이름 입력 받기 → `register()` : 자동차 이름을 등록하여 자동차 List return.
   2. 이동 횟수 입력 받기 → `howManyTimes()` : 이동횟수를 입력받고 적절하면 int type return.
2. 적절한 입력인지 검사하는 기능

`service` package에서 관리.

<br>

## Validator

1주차의 목표는 method의 분리. 이번 2주차의 목표는 Class의 분리이다. 따라서 `UserInputService`의 책임 중, '검증하는 기능'을 따로 분리하여 class로 구현할 것이다.

### 생성할 기능 목록

1. 이름이 올바른지 확인
   1. 글자 수 1~5 글자.
   2. 중복되면 안됨.
2. 이동 횟수가 올바른지 확인
   1. 숫자가 들어와야 함.
   2. 0이 아닌 양의 정수가 들어와야 함.

`utils` package 에서 관리.

<br>

## Viewer

`GameHandler` 의 책임이 여전히 많다고 느껴진다. 따라서 화면에 '출력하는 부분'의 책임을 담당하는 `Viewer` class를 만들려고 한다.

### 생성할 기능 목록

1. 각각의 이동마다 자동차의 위치를 출력하는 기능.
2. 우승자 출력하는 기능.

`utils` package에서 관리.

<br>

## CarService

`GameHandler` 의 책임을 분리하기 위한 클래스.

### 생성할 기능 목록

1. 경기에 참여할 자동차 리스트 생산.
2. 모든 자동차 이동.

`service` package 에서 관리.

<br>

## Constant

1. `MIN_CONDITION` : Random 숫자 범위의 최솟값.(==0)
2. `MAX_CONDITION` : Random 숫자 범위의 최댓값.(==9)
3. `MIN_NAME_LENGTH` : 이름의 글자 수 최솟값.(==1)
4. `MAX_NAME_LENGTH` : 이름의 글자 수 최댓값.(==5)
5. `IMPROPER_CHARACTER`(=='`,`')
6. `SPLIT_STRING`(=="`,`")
7. `MOVING_FORWARD`: ==4. 차가 움직일 수 있는 조건의 최솟값
8. `INVALID_STAGE_NUMBER` : 적절하지 않은 이동 횟수. == -1
9. `EMPTY` : 빈 문자열 표시. == ""
10. `SPACE` : 띄워쓰기 문자열. == " "
11. `COLON` : 콜론. == " : "
12. `PROGRESS` : 자동차의 위치를 나타내기 위한 문자. == "-"

<br>

<br>

## Message

1. `START` : "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
2. `ERROR_INVALID_NAME_FORMAT` : "[ERROR] 자동차의 이름은 중복없이 1~5글자 입니다"
3. `ASK_STAGES` : "시도할 회수는 몇회인가요?"
4. `ERROR_INVALID_STAGE_VALUE` : "[ERROR] 시도할 횟수는 숫자여야 합니다"
5. `EXECUTE_RESULT` : "실행 결과"
6. `WINNERS` : "최종 우승자 : "

