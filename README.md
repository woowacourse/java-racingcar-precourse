# 미션 - 자동차 경주 게임

안녕하세요 👋

우아한테크코스 4기 프리코스 2주차 미션인 자동차 경주 게임을 구현한 저장소입니다.
사용자가 자동차의 이름과 시도 횟수를 입력하면 경주 결과와 최종 우승자를 출력합니다.

---

## 📔 기능 목록

- [x] 차의 이름을 설정하는 기능
  - [x] 차의 이름을 입력받는 기능
  - [x] 차의 이름의 유효성 검증
  - [x] 유효성 검증 실패 시 재입력
  - [x] 단위 테스트
- [x] 시도할 회수를 설정하는 기능
  - [x] 시도 횟수를 입력받는 기능
  - [x] 시도 횟수의 유효성 검증
  - [x] 유효성 검증 실패 시 재입력
  - [x] 단위 테스트
- [x] 차를 전진/정지하는 기능
  - [x] 자동차의 전진/정지 기능
  - [x] 모든 자동차의 전진/정지 기능
  - [x] 단위 테스트
- [x] 차수별 실행 결과를 출력하는 기능
  - [x] 단위 테스트
- [x] 최종 우승자 찾는 기능
  - [x] 단위 테스트
- [x] 최종 우승자를 출력하는 기능
  - [x] 단위 테스트
- [x] 프로그램이 동작하도록 기능 통합
- [x] 전체 테스트

---

[comment]: <> (## 🎯 추가할 기능 목록)

[comment]: <> (<br><br>)

[comment]: <> (---)

## 🔍 기능 살펴보기

실행 화면으로 예시를 들어 기능을 살펴본다.

### 차의 이름을 설정하는 기능

경주 할 자동차 이름을 입력한다. 이름은 쉽표(,)로 구분한다.

이름은 1자 이상 5자 이하여야 하고 중복된 이름이 있으면 안된다.

- 실행 예시

```text
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
```

### 시도할 회수를 설정하는 기능

경주를 할 시도 횟수를 입력한다. 시도 횟수는 1이상 2147483647 이하의 정수여야한다.

- 실행 예시

```text
시도할 회수는 몇회인가요?
3

```

### 차를 전진/정지하는 기능

모든 자동차는 시도 횟수만큼 이동을 시도할 수 있다.

0부터 9까지의 수를 무작위로 뽑은 뒤 4이상인 경우 전진한다.

### 차수별 실행 결과를 출력하는 기능

먼저 실행 결과를 출력한 뒤 자동차의 전진/정지 결과를 차수별, 이름 순서대로 출력한다.

이름 순서는 사용자가 입력한 이름을 ,로 구분한 순서이다.

각 차수마다 한번의 개행을 해 구분한다.

```text
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

```

### 최종 우승자 찾는 기능

경주가 끝난 뒤 가장 많이 전진한 자동차가 우승자가 된다.

여러 자동차의 전진 횟수가 같은 경우 공동 우승자가 된다.

### 최종 우승자를 출력하는 기능

최종 우승자를 자동차 이름 순서대로 출력한다.

공동 우승자인 경우 이름 사이에 (, )로 구분한다.

```text
최종 우승자 : pobi, jun
```

### 실행 결과 예시
```text
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
3

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

최종 우승자 : pobi, jun
```

---

## 💻 사용 컨벤션

- 자바 코딩 컨벤션
  - [캠퍼스 핵데이 Java 코딩 컨벤션](https://naver.github.io/hackday-conventions-java)
- git 커밋 메시지 컨벤션
  - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

## 🚫 요구사항

- JDK 8버전을 사용해야한다.
- indent depth을 2이하로 구현해야한다.
- 메소드의 길이가 15라인을 넘지 않도록 구현해야 한다.
- 3항 연산자를 사용하면 안된다.
- else 에약어를 사용하면 안된다.
- switch/case를 사용하면 안된다.
- Car 객체를 활용해 구현해야 한다.
  - Car 기본 생성자를 추가할 수 없다.
  - name, position 변수의 접근 제어자인 private을 변경할 수 없다.
  - setPosition(int position) 메소드를 추가하지 않는다.
- JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

<br>

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
