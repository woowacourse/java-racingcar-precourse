# 미션 - 자동차 경주 게임

## 기능 구현 목록

- [x] 사용자가 잘못된 값을 입력 처리 하기 InputView
    - [x] `IllegalArgumentException`를 발생
    - [x] 그 부분부터 입력 다시 받기
- [x] "[ERROR]"로 시작하는 에러 메시지를 출력 OutputView#printError
- [x] 각 자동차에 이름 받아오기 InputView#getNames
    - [x] 개별 이름은 5자 이하만 가능 Util#checkNamesValidation
        - 그외 빈값 허용안함, 최소2명이상 입력, 중복 허용안함 등의 검증 로직 추가
- [x] 몇 번의 이동을 할 것인지를 입력 받는 기능 InputView#getCount
    - [x] 입력된 횟수에 대한 검증 기능 Util#checkCountValidation
- [x] 입력받은 이름으로 자동차들 생성하는 로직 구현 Cars
- [x] 입력받은 횟수 동안 자동차 경주를 시행하도록 하는 로직 Count#isRacingEnd
    - [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈추는 기능 Car
        - [ ] 무작위 값이 4 이상일 경우 position +1 올라가도록 구현
    - [ ] 0에서 9 사이에서 무작위 값을 구하는 기능 Util
- [ ] 매 경주당 결과 출력하는 기능 RacingGame
    - [ ] 각 자동차별 결과(자동차 이름과 전진 거리)를 문자열 반환해주는 기능 Cars
    - [ ] 경주당 결과를 출력하는 기능. OutputView
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지 알려주는 기능 RacingGame
    - [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분하여 문자열 반환 기능 Cars

## ✍🏻 입출력 요구사항

### ⌨️ 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

### 🖥 출력

- 각 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR] 로 시작해야 한다.

```
[ERROR] 시도 횟수는 숫자여야 한다.
```

### 💻 프로그래밍 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```
