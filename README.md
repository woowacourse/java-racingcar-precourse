# 미션 - 자동차 경주 게임

구현 순서 : 상수→멤버 변수→생성자→메서드

## Car

1. 매직넘버를 피하기 위한 상수가 필요. → 무작위 값의 범위를 정해주는 `MIN_CONDITION = 0, MAX_CONDITION = 0` 을 상수로 생성.

   → `Constant` 객체에 `static final` 선언하여 사용.

2. 현재 위치 `postition` 에 대한 정보를 `GameHandler` 에게 전해줄 메서드 → `currentPostition()`

3. 자동차가 전진하는 행위에 대한 method 생성. → `go()` 

   - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우

## GameHandler

