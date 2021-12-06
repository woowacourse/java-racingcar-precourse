# 미션 - 자동차 경주 게임

## 🛠 구현 기능 목록

초간단 자동차 경주 게임을 구현한다.

### 1. 자동차
* [x] 자동차는 이름을 가질 수 있다.
* [x] 자동차의 이름은 `5자 이하`만 가능하다.
* [x] 자동차의 이름은 `공백`이거나 `비어있는 경우` 예외 처리를 진행한다. 아래는 예외 처리가 일어날 수 있는 이름의 예시이다.
    * `''`
    * `' '`
    * `'   '`
* [x] 자동차는 전진 또는 멈출 수 있다.
* [x] 자동차는 이동 유무를 판단하는 `isMoving` 메서드를 가진 `MovingPolicy` 인터페이스를 가진다.
    * [x] 자동차의 전진 유무는 `MovingPolicy`의 `isMoving`을 통해 확인한다.
    * [x] `MovingPolicy`의 구현체인 `RandomMovingPolicy`을 활용하여 `0에서 9 사이에 무작위 값`을 구한 후 무작위 값이 `4 이상`일 경우 전진한다.

### 2. 입력
* [x] 경주할 자동차 이름을 입력 받는다.
    * [x] 경주할 자동차 이름은 쉼표를 기준으로 나눈다.
    * [x] 입력 받은 자동차 이름은 List로 변환되어 전달한다.
* [x] 시도할 회수를 입력 받는다.

### 3. 시도 회수
* [x] 시도할 회수를 표현하기 위한 역할을 가진다.
* [x] 시도할 회수가 `숫자가 아니면` 예외를 던진다.
* [x] 시도할 회수가 `음수`이면 예외를 던진다.

### 4. 자동차 리스트
* [x] 자동차들을 관리하는 일급 컬렉션이다.
* [x] 자동차의 이름이 `중복`되는 경우 예외를 던진다.
* [x] 자동차들을 일괄적으로 움직이게할 수 있다.
* [x] 각 차수별 실행 결과를 만들어 반환한다.
* [x] 최종 우승자 안내 문구를 제공한다.

### 5. 게임 실행
* [x] 레이싱 게임을 실행할 수 있다.
* [x] 레이싱 게임은 반복되지 않는다.
* [x] 예외 처리가 일어나면 입력을 다시 받는다.

### 6. 출력
* [x] 결과값 출력에 대한 전반적인 책임을 가진다.
* [x] `IllegalArgumentException`이 발생할 경우 `"[ERROR]"로 시작하는 에러 메시지 출력`을 진행한다.

## 고민 사항 기록

1주차 피드백과 2주차 미션을 해결하며 고민하고 학습한 것을 공유하기 위해 아래와 같이 기록을 진행하였습니다.

* [1. 살아 있는 문서](https://hyeonic.github.io/%EA%B8%B0%ED%83%80/woowacourse/precourse-2.html#_1-%E1%84%89%E1%85%A1%E1%86%AF%E1%84%8B%E1%85%A1-%E1%84%8B%E1%85%B5%E1%86%BB%E1%84%82%E1%85%B3%E1%86%AB-%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5)
* [2. 구현 순서 맞추기](https://hyeonic.github.io/%EA%B8%B0%ED%83%80/woowacourse/precourse-2.html#_2-%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB-%E1%84%89%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5-%E1%84%86%E1%85%A1%E1%86%BD%E1%84%8E%E1%85%AE%E1%84%80%E1%85%B5)
* [3. 매직 넘버, 매직 리터럴](https://hyeonic.github.io/%EA%B8%B0%ED%83%80/woowacourse/precourse-2.html#_3-%E1%84%86%E1%85%A2%E1%84%8C%E1%85%B5%E1%86%A8-%E1%84%82%E1%85%A5%E1%86%B7%E1%84%87%E1%85%A5-%E1%84%86%E1%85%A2%E1%84%8C%E1%85%B5%E1%86%A8-%E1%84%85%E1%85%B5%E1%84%90%E1%85%A5%E1%84%85%E1%85%A5%E1%86%AF)
* [4. Car, Strategy Pattern 적용](https://hyeonic.github.io/%EA%B8%B0%ED%83%80/woowacourse/precourse-2.html#_4-car-strategy-pattern-%E1%84%8C%E1%85%A5%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC)
* [5. 캡슐화](https://hyeonic.github.io/%EA%B8%B0%ED%83%80/woowacourse/precourse-2.html#_5-%E1%84%8F%E1%85%A2%E1%86%B8%E1%84%89%E1%85%B2%E1%86%AF%E1%84%92%E1%85%AA)
* [6. String의 split 메서드](https://hyeonic.github.io/%EA%B8%B0%ED%83%80/woowacourse/precourse-2.html#_6-string%E1%84%8B%E1%85%B4-split-%E1%84%86%E1%85%A6%E1%84%89%E1%85%A5%E1%84%83%E1%85%B3)
* [7. String + 연산자보다 StringBuilder](https://hyeonic.github.io/%EA%B8%B0%ED%83%80/woowacourse/precourse-2.html#_7-string-%E1%84%8B%E1%85%A7%E1%86%AB%E1%84%89%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A9%E1%84%83%E1%85%A1-stringbuilder)
* [8. 모든 원시값과 문자열을 포장하라](https://hyeonic.github.io/%EA%B8%B0%ED%83%80/woowacourse/precourse-2.html#_8-%E1%84%86%E1%85%A9%E1%84%83%E1%85%B3%E1%86%AB-%E1%84%8B%E1%85%AF%E1%86%AB%E1%84%89%E1%85%B5%E1%84%80%E1%85%A1%E1%86%B9%E1%84%80%E1%85%AA-%E1%84%86%E1%85%AE%E1%86%AB%E1%84%8C%E1%85%A1%E1%84%8B%E1%85%A7%E1%86%AF%E1%84%8B%E1%85%B3%E1%86%AF-%E1%84%91%E1%85%A9%E1%84%8C%E1%85%A1%E1%86%BC%E1%84%92%E1%85%A1%E1%84%85%E1%85%A1)
* [9. 단위 테스트 명명법](https://hyeonic.github.io/%EA%B8%B0%ED%83%80/woowacourse/precourse-2.html#_9-%E1%84%83%E1%85%A1%E1%86%AB%E1%84%8B%E1%85%B1-%E1%84%90%E1%85%A6%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3-%E1%84%86%E1%85%A7%E1%86%BC%E1%84%86%E1%85%A7%E1%86%BC%E1%84%87%E1%85%A5%E1%86%B8)

전체 내용은 [배움을 기록](https://hyeonic.github.io/%EA%B8%B0%ED%83%80/woowacourse/precourse-2.html) 에서 확인할 수 있습니다.

## 패키지 구조

 * main/java/racingcar
   * domain
     * car
       * Car.java
       * Cars.java
       * MovingPolicy.java
       * RandomMovingPolicy.java
     * error
       * ErrorMessage.java
     * game
       * GameMachine.java
     * trycount
       * TryCount.java
   * view
     * InputView.java
     * OutputView.java
   * Application.java
 * test/java/racingcar
   * domain
     * car
       * CarTest.java
       * CarsTest.java
     * trycount
       * TryCountTest.java
     * view 
       * InputViewTest.java
   * ApplicationTest.java

## 게임 실행

### 정상 진행

```bash
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

pobi : -
woni : 
jun : -

pobi : -
woni : -
jun : --

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : --

pobi : ----
woni : ---
jun : --

최종 우승자 : pobi
```

### 에러 발생

#### 1. 차 이름이 비어 있는 경우
```bash
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)

[ERROR] 비어 있는 차 이름이 존재 한다.
```

#### 2. 차 이름이 공백인 경우
```bash
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
 , ,
[ERROR] 공백을 가진 차 이름이 존재 한다.
```

#### 3. 차 이름이 중복되는 경우
```bash
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,pobi
[ERROR] 차 이름은 중복될 수 없다.
```

#### 4. 차 이름의 길이가 5를 초과한 경우
```bash
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobiiii,woni,jun
[ERROR] 차 이름의 길이는 5이하 이다.
```

#### 5. 시도 횟수가 숫자가 아닌 경우
```bash
시도할 회수는 몇회인가요?
1a
[ERROR] 시도 횟수는 숫자여야 한다.
```

#### 6. 시도 횟수가 음수인 경우
```bash
시도할 회수는 몇회인가요?
-1
[ERROR] 시도 횟수는 음수가 아니어야 한다.
```