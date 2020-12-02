# 미션 - 자동차 경주 게임

## 🤔 클래스 나누기

### 자동차

경주에 참여할 자동차의 클래스이다.

자동차 클래스는 다음과 같은 요소들을 가져야 한다:

- 상수
    - [ ] `nextInt`에 사용할 최솟값
    - [ ] `nextInt`에 사용할 최댓값
    - [ ] 전진 성공 여부를 판별할 때 사용할 조건값
- 클래스 변수
    - [X] 자동차 이름
    - [X] 자동차의 현재 위치
- 클래스 메소드
    - [X] 생성자 (`public`)
    - [ ] 전진 성공 여부를 참/거짓으로 알려주기 (`private`)
        - 랜덤한 값을 `nextInt` 메소드로 가져옴
        - 전진 성공 조건값 이상일 경우 참, 아닐 경우 거짓 반환
    - [ ] 전진하기 (`public`)
    - [ ] 자신의 이름 알려주기 (`public`)
    - [ ] 자신의 현재 위치 알려주기 (`public`)

### 레이싱 서킷

자동차 객체들을 담을 일급 컬렉션이다.

레이싱 서킷 클래스는 다음과 같은 요소들을 가져야 한다:

- 클래스 변수
    - [ ] 서킷에 있는 자동차의 배열
- 클래스 메소드
    - [ ] 생성자 (`public`)
        - 문자열의 리스트를 입력받음
        - 리스트 내의 문자열을 자동차 이름으로 가지는 배열 초기화
    - [ ] 현재 서킷의 상태 알려주기 (`public`)
    
### 레이싱 경기

레이싱 경기에 필요한 작업들을 모아둘 클래스이다.

레이싱 경기 클래스는 다음과 같은 요소들을 가져야 한다:

- 클래스 변수
    - [ ] 현제 경기에서 사용중인 서킷
    - [ ] 현재 경기에서 자동차들이 전진을 시도할 총 횟수
    - [ ] 현재까지의 전진 시도 횟수
- 클래스 메소드
    - [ ] 생성자 (`public`)
        - 문자열의 리스트와 전진 시도 횟수를 입력받음
        - 리스트를 이용해 서킷 생성 후 클래스 변수로 할당
        - 입력받은 총 전진 시도 횟수를 검증한 후 클래스 변수로 할당
        - 현재까지의 전진 시도 횟수를 0으로 초기화
    - [ ] 입력받은 전진 시도 횟수 검증하기 (`private`)
        - 전진 시도가 음수가 아닌 정수인지 확인
    - [ ] 서킷의 모든 차에게 전진 명령을 내리기 (`public`)
    - [ ] 현재 경기의 서킷 상태 제공하기 (`public`)
    - [ ] 경기가 끝났는지 여부 확인해주기 (`public`)

### 콘솔 입/출력

게임의 진행을 사용자로부터의 콘솔 입/출력을 통해 진행할 클래스이다.

콘솔 입/출력 클래스는 다음과 같은 요소들을 가져야 한다:

- 상수
    - [ ] 자동차 이름의 최대 글자수
    - [ ] 자동차 이름 입력을 요구할 때 출력할 문구 문자열
    - [ ] 전진 시도 횟수 입력을 요구할 때 출력할 문자열
    - [ ] 실행 결과를 출력하기 전에 사전에 출력할 문자열
    - [ ] 승자를 출력하기 전에 사전에 출력할 문자열
- 클래스 변수
    - [ ] 콘솔 입력용 스캐너
    - [ ] 현재 게임에 사용할 레이싱 경기
- 클래스 메소드
    - [ ] 생성자 (`public`)
        - 스캐너를 입력받아 클래스 내의 스캐너에 할당
    - [ ] 자동차 이름 목록 문자열 파싱하기 (`private`)
        - 입력받은 문자열을 `,` 글자를 기준으로 나누어 리스트에 저장
        - 자동차 이름 리스트를 검증 메소드를 이용해 검증함
        - 리스트 내의 모든 문자열을 검증 메소드를 이용해 검증함
        - 문자열의 리스트 반환
    - [ ] 자동차 이름 리스트 검증하기 (`private`)
        - 리스트가 비어있지 않은지 확인
    - [ ] 자동차 이름 문자열 검증하기 (`private`)
        - 문자열의 길이가 지정된 최대 글자수 이하인지 확인
    - [ ] 전진 시도 횟수 문자열 파싱하기 (`private`)
    - [ ] 전진 시도 횟수 문자열 검증하기 (`private`)
        - 문자열이 정수만으로 이루어져 있는지 확인
    - [ ] 현재의 서킷 상태 출력하기 (`private`)
    - [ ] 게임의 승자 출력하기 (`private`)
    - [ ] 게임 실행하기 (`public`)

<br>

## 🚀 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

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
최종 우승자: pobi
```
- 공동 우승자 안내 문구
```
최종 우승자: pobi, jun
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

최종 우승자: pobi, jun
```

<br>

## 🎱 프로그래밍 요구사항
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 프로그래밍 요구사항에서 별도로 변경 불가 안내가 없는 경우 파일 수정과 패키지 이동을 자유롭게 할 수 있다.
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 `[ERROR]` 로 시작해야 한다.

### 추가된 요구사항
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 프로그래밍 요구사항 - Application
- Application 클래스를 활용해 구현해야 한다.
- Application의 패키지 구조와 구현은 변경하지 않는다.
- `final Scanner scanner = new Scanner(System.in);`는 변경하지 않는다.
- `// TODO 구현 진행` 이 후 부터 구현한다.

```java
public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
    }
}
```

### 프로그래밍 요구사항 - RandomUtils
- RandomUtils 클래스를 활용해 랜덤 기능을 구현해야 한다.
- RandomUtils의 패키지 구조와 구현은 변경하지 않는다.

```java
private static final Random RANDOM = new Random();
    private RandomUtils() {
    }
    public static int nextInt(final int startInclusive, final int endInclusive) {
    ...
```

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

<br>

## 📈 진행 요구사항
- 미션은 [java-racingcar-precourse 저장소](https://github.com/woowacourse/java-racingcar-precourse) 를 fork/clone해 시작한다.
- 기능을 구현하기 전에 java-racingcar-precourse/docs/README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
  - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를 남긴다.
- [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 절차를 따라 미션을 제출한다.
  - [프리코스 과제 FAQ](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse/faq) 문서를 참고하여 진행할 수 있다.

<br>

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
