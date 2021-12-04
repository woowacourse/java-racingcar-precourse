# 미션 - 자동차 경주 게임

## ✔️ 서비스 흐름
1. 프로그램이 시작한다.
2. 사용자에게 경주 할 자동차 이름(',' 기준으로 나뉨)을 입력 받는다.
3. 사용자에게 시도할 횟수를 입력받는다.
4. 입력받은 시도 횟수만큼 반복한다.
5. 각각에 자동차를 대상으로 랜덤값을 생성한다.
6. 생성한 랜덤값이 기준치가 넘으면 이동한 거리의 값을 1 추가한다.
7. 자동차가 이동한 거리만큼 '-'를 출력한다. ex) `pobi : --`
8. 최종 우수자(복수 가능) 출력한다.
9. 프로그램이 종료된다.

## ✔️ 서비스에 따른 기능 세분화
2. 사용자에게 경주 할 자동차 이름(',' 기준으로 나뉨)을 입력 받는다.
   1. 사용자에게 자동차 이름을 입력받는다.
   2. ',' 을 기준으로 각각의 자동차들로 개체를 분리한다. 
   3. 분리한 자동차 개체를 생성한다.
   4. 만약 ',' 이 아닌 값을 입력한 경우, `NOT_USE_CORRECT_PUNCTUATION_MARK`을 따른다.
   5. 만약 자돌차의 이름이 5글자를 초과한 경우, `USE_MORE_THAN_5_LETTERS`을 따른다.
3. 사용자에게 시도할 횟수를 입력받는다.
   1. 사용자에게 시도할 횟수를 입력받는다.
   2. 만약 수가 아닌 값을 입력한 경우, `NOT_USE_CORRECT_LETTER`을 따른다.
4. 시도 횟수만큼 반복한다.
5. 각각의 자동차를 대상으로 램덤값을 생성한다.
6. 생성한 랜덤값이 기준치가 넘으면, 해당 자동차 개체의 이동 거리의 값을 1 더한다.
7. 저장된 모든 자동차 개체의 이동거리를 '-'로 출력한다.(이동거리 = '-'의 개수)

## ✔️ 객체 관계
### RacingCarGame
: 레이싱 게임을 위한 개체입니다. 프로그램 시작 시, 해당 개체는 자동적으로 생성돼 게임을 시작하게됩니다.

- 지역 변수
  - `ArrayList<Car> racingCars`: 자동차 개체들의 배열을 저장할 리스트
  - `numberOfTrial`: 시도 횟수

- 메소드
    - `play()` 
    - `getRacingCarsNameFromUser()`
    - `seperatedByMark(char mark)`: 예외처리 2-4, 2-5 포함
    - `createRacingCarEntity(String carName)`: 생성 및 racingCar 배열에 담기
    - `getNumberOfTrialFromUser()`: 예외처리 3-2 포함


### Car
: 레이싱 게임에 참여하는 레이싱 카에 대한 개체입니다.

- 지역 변수
  - `name`: 레이싱 카의 이름
  - `position`: 이동 횟수

- 메소드
  - `generateRamdomValue()`
  - `updatePosition()`
  - `indicatePosition()`
  - `toString()`

## ✔️ 예외 처리
`IllegalArgumentException` <br>

[예외 종류]
- NOT_USE_CORRECT_PUNCTUATION_MARK: 자동차 입력 시, ','를 사용하지 않음
- USE_MORE_THAN_5_LETTERS: 시도할 횟수 입력 시, 5글자 초과 사용
- NOT_USE_CORRECT_LETTER: 시도할 횟수 입력 시, 숫자가 아닌 값 입력
