# 자동차 경주 게임 🚗

> 우아한 테크 코스 :: 온라인 과제 2주차
   
&nbsp;

## 기능 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9사이에서 random값을 구한 후 random값이 4이상일 경우 전진하고, 3이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

&nbsp;

## 프로그래밍 요구사항

### 1) 객체

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
} 
```

### 2) 1주차와 동일
- 자바 코드 컨벤션을 지키면서 프로그래밍 한다.
    + 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- indent(인덴트,들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    + 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    + 힌트: indent(인덴트,들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.

### 3) 2주차 변경 및 추가
- 함수(또는메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    + 함수(또는메소드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    + 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    + else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
