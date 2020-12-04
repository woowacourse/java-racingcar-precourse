# 프리코스 2주차 - 자동차 경주 게임

Java 언어로 자동차 경주 게임을 구현하는 저장소입니다.

## 목차

1. [기능 요구사항](#기능 요구사항)

2. [입출력 요구사항](#입출력 요구사항)

3. [프로그래밍 요구사항](#프로그래밍 요구사항)

4. [구현할 기능 목록](#구현할 기능 목록)

<br>

## 기능 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

<br>

## 입출력 요구사항

### 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

### 출력

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

### 프로그래밍 실행 결과 예시

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

## 프로그래밍 요구사항

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

## 구현할 기능 목록

### 구현 순서

1. **자동차의 이름을 입력받기**
   * [x] 사용자 입력을 받고 쉼표를 기준으로 나누어 자동차 이름들을 문자열 배열로 반환하는 기능
      * **예외 처리**
         * [x] 입력에 쉼표가 존재하지 않을 경우
         * [x] 입력이 쉼표로 시작하거나 끝날 경우
         * [x] 자동차 이름의 길이가 1~5가 아닐 경우
         * [x] 자동차 이름이 공백문자일 경우
   * [x] 자동차 이름 배열로부터 `Car` 인스턴스를 생성하여 `CarList`로 저장하는 기능
  
2. **이동 횟수를 입력받기**
   * [x] 사용자 입력을 받아 `int`로 반환하는 기능
      * **예외 처리**
         * [x] 입력이 숫자가 아닐 경우 (정규식 사용)
         * [x] 입력이 `int` 범위를 벗어나는 경우 (2,147,483,647)
           * 입력이 숫자인데도 parseInt() 시 NumberFormatException 예외를 일으키는 경우로 처리함
         * [x] 입력이 0일 경우

3. **입력받은 횟수만큼 각 자동차를 전진시키기**
   * [x] (Car) random값을 통해 전진하는 기능과 getter 기능
   * [x] 입력 횟수만큼 모든 자동차를 전진시키는 기능
   * [x] 1회 전진 후 이동 현황을 출력하는 기능

4. **경주 결과를 출력하기**
   * [ ] 최종 우승자를 계산하여 반환하는 기능
   * [ ] 최종 우승자를 출력하는 기능

### 구현 시 체크리스트

* [ ] [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) 지키기 (단 indent는 4 space)
* [ ] indent depth를 2 이하로 구현하기
* [ ] 3항 연산자를 사용하지 않기
* [ ] 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들기
* [ ] 예외 상황 시 `[ERROR]`로 시작하는 에러 문구를 출력하기
* [ ] 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현하기
* [ ] else, switch/case 예약어 사용하지 않기