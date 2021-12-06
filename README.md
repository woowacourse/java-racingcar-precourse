# 미션 - 자동차 경주 게임

## 기능 목록

1. 사용자는 자동차 이름 n개를 입력한다.
    - 이름 구분은 쉼표(,)를 기준으로 한다.
2. 자동차 이름 n개 입력값에 대한 검증을 진행한다.
    - 이름은 5자 이하
    - 이름은 중복되지 않음
    - 잘못된 입력 값 입력할 경우 `IllegalArgumentException` 발생, "[ERROR]"로 시작하는 에러 메시지를 출력, 2.로
3. 사용자는 시도 횟수를 입력한다.
4. 시도 횟수 입력값을 검증한다.
    - 잘못된 입력 값 입력할 경우 `IllegalArgumentException` 발생, "[ERROR]"로 시작하는 에러 메시지를 출력, 4.로
5. 라운드
    - 각 자동차는 내부적으로 0에서 9사이의 무작위 값을 생성한다.
    - 생성값이 4이상인 경우 한 칸 이동한다.
    - 실행 결과를 출력한다.
    - 입력받은 시도 횟수만큼 5. 반복
6. 우승자 발표
    - 가장 많이 이동한 자동차의 이름을 출력한다.
    - 최고점 동점일 경우 이름을 쉼표(,)로 구분하여 출력.

## 도메인 분리

### InputView

- 역할 : 사용자로부터 입력을 받는다. (값을 조작하지 않는다)
- 책임
    - 사용자로부터 자동차 이름 목록을 입력받는다.
    - 사용자로부터 라운드 수를 입력받는다.

### ResultView

- 역할 : 결과를 출력한다.
- 책임
    - 게임 결과를 출력한다.

### ErrorView

- 역할 : 에러를 출력한다.
- 책임
    - 에러 메시지를 출력한다.

---

### GameController

- 역할 : View -> Model, Model -> View로 데이터 중개를 담당한다. (값을 조작하지 않는다)
- 책임
    - 프로그램을 시작하라
    - 자동차 이름 목록을 요청하라 to InputView
    - 입력값으로 Cars 인스턴스를 생성하라 to Cars
    - 라운드 수를 요청하라 to InputView
    - Cars 인스턴스로 게임을 초기화(생성)하라 to racingCarGame
    - 게임을 시작하라 to racingCarGame
    - 게임 결과를 생성하라 to RacingCarGame
    - 게임 결과를 출력하라 to ResultView
    - 모델에서 발생한 에러를 핸들링

---

### RacingCarGame

- 역할 : 게임을 진행
- 책임
    - 라운드 수와 Cars를 입력받아 생성
    - 라운드 수를 검증
    - 게임을 시작(차들을 이동시켜라 to Cars)
    - 게임 상태를 만듦(각 자동차의 이름과 위치를 포함하는 데이터)

### Cars

> `Car` 객체를 포함

- 책임
    - 생성 시 게임 규칙에 맞는 이름 검증
    - 이동하라 to each Car

### Car

- 책임
    - 이동하기
        - 랜덤 넘버를 생성
        - Threshold 값을 기준으로 이동 여부 판단

### GameStatus

- 책임
    - 우승자 선정

## 🚀 기능 요구사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- 아래의 프로그래밍 실행 결과 예시와 동일하게 입력과 출력이 이루어져야 한다.

<br>

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

<br>

## 🎱 프로그래밍 요구사항

- 프로그램을 실행하는 시작점은 `Application`의 `main()`이다.
- JDK 8 버전에서 실행 가능해야 한다. **JDK 8에서 정상 동작하지 않을 경우 0점 처리**한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - https://naver.github.io/hackday-conventions-java
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 프로그래밍 요구사항에서 별도로 변경 불가 안내가 없는 경우 파일 수정과 패키지 이동을 자유롭게 할 수 있다.

### 추가된 요구사항

- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 프로그래밍 요구사항 - Car 객체

- 다음 Car 객체를 활용해 구현해야 한다.
- Car 기본 생성자를 추가할 수 없다.
- name, position 변수의 접근 제어자인 private을 변경할 수 없다.
- 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.

```java
public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
}
```

### 프로그래밍 요구사항 - Randoms, Console

- JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을 때 `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**

<br>

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
