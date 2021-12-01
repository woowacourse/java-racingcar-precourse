# 미션 - 자동차 경주 게임

구현 순서 : 상수→멤버 변수→생성자→메서드

## Car

1. 매직넘버를 피하기 위한 상수가 필요. → 무작위 값의 범위를 정해주는 `MIN_CONDITION = 0, MAX_CONDITION = 0` 을 상수로 생성.

   → `Constant` 객체에 `static final` 선언하여 사용.

2. 현재 위치 `postition` 에 대한 정보를 `GameHandler` 에게 전해줄 메서드 → `currentPostition()`

3. 자동차가 전진하는 행위에 대한 method 생성. → `go()` 

   - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우

4. (수정) `GameHandler` 가 자동차의 이름을 알 수 있게 하기 위해서 `name()` method 필요.

<br>

## GameHandler

1. (수정) 글자 수 최소, 최대 상수 필요  (`Constant` 객체에 추가할 예정)
   1.  `MIN_NAME_LENGTH`(==1)
   2.  `MAX_NAME_LENGTH` (==5)
   3. `IMPROPER_CHARACTER`(=='`,`')
   4. `SPLIT_STRING`(=="`,`")
2. 멤버 변수
   1. 자동차들에 대한 정보 필요 → `private List<Car> cars`
   2. 얼마나 이동할 것인지에 대한 정보 저장 필요 → `private int stages`
3. 자동차들을 생성해야 함 → `createCars()`
   1. 처음에 자동차 이름을 받아야 함 → `getCarsName()` 
      1. 사용자의 입력을 받는 method → `getUserInputNames()`
         1. 각 자동차의 이름 확인하는 method 필요. → `checkValidName()`
            1. 글자수 1~5인지 판단해줘야 함 → `isInValidNameLength(String name)`
            2. 맨 뒤에 `,` 가 쓰였는지 확인해줘야 함. → `isLastCharImproper(String userInput)`
   2. 잘못된 입력이면 다시 받도록 해야 함 (1-1, 1-2 는 `try-catch` 로 구현하기)
4. 몇번의 이동을 할지 정해야 함. → `getStages()`
   1. 사용자의 입력을 받아야 함. → `getUserInputStages()`
      1. 사용자의 입력이 `int type` 이 아니면 `IllegalArugmentException`
5. 이동횟수만큼 자동차들이 `go` 하게 만든다.
6. 매 이동횟수 때마다 결과를 보여줘야 한다. → `showEachStageResult(List<Car> cars)`
7. 이동이 모두 끝나면 각 자동차들의 현재위치 중 가장 큰 값을 가진 자동차들을 찾고 우승자로 나열한다. → `showWinners(List<Car> cars)`
8. 위 method들을 하나의 프로세스로써 묶어줘야 함. → `run()` method 생성.
   1. `createCars()` → 알맞은 자동차 생성
   2. `getStages()` → 얼마나 이동할 것인지
   3. `excuteStage()` → 이동횟수 만큼 아래의 프로세스를 실행 
      1. 각 자동차들 모두 `go`.
      2. 각 자동차들 현재 위치 출력. → `showEachStageResult(List<Car> cars)`
   4. 우승자 출력 →  `showWinners(List<Car> cars)`

<br>

## Constant

1. `MIN_CONDITION` : Random 숫자 범위의 최솟값.(==0)
2. `MAX_CONDITION` : Random 숫자 범위의 최댓값.(==9)
3. `MIN_NAME_LENGTH` : 이름의 글자 수 최솟값.(==1)
4. `MAX_NAME_LENGTH` : 이름의 글자 수 최댓값.(==5)
5. `IMPROPER_CHARACTER`(=='`,`')
6. `SPLIT_STRING`(=="`,`")

<br>

