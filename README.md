# 미션 - 자동차 경주 게임

구현 순서 : 상수→멤버 변수→생성자→메서드

## Car

1. 매직넘버를 피하기 위한 상수가 필요. → 무작위 값의 범위를 정해주는 `MIN_CONDITION = 0, MAX_CONDITION = 0` 을 상수로 생성.

   → `Constant` 객체에 `static final` 선언하여 사용.

2. 현재 위치 `postition` 에 대한 정보를 `GameHandler` 에게 전해줄 메서드 → `currentPostition()`

3. 자동차가 전진하는 행위에 대한 method 생성. → `go()` 

   - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우

<br>

## GameHandler

1. 자동차들을 생성해야 함 → `createCars()`

   1. 처음에 자동차 이름을 받아야 함 → `getCarsName()` 

      1. 각 자동차의 이름 확인하는 method 필요. → `checkValidName()`

         → 글자수 1~5인지 판단해줘야 함 → `validLength(String name)`

   2. 잘못된 입력이면 다시 받도록 해야 함 (1-1, 1-2 는 `try-catch` 로 구현하기)

2. 몇번의 이동을 할지 정해야 함.

   1. 사용자의 입력을 받아야 함.
      1. 사용자의 입력이 `int type` 이 아니면 `IllegalArugmentException`

3. 이동횟수만큼 자동차들이 `go` 하게 만든다.

4. 이동이 모두 끝나면 각 자동차들의 현재위치 중 가장 큰 값을 가진 자동차들을 찾고 우승자로 나열한다. → `showWinners(Car[] cars)`

<br>

## Constant

1. `MIN_CONDITION` : Random 숫자 범위의 최솟값.(==0)
2. `MAX_CONDITION` : Random 숫자 범위의 최댓값.(==9)

