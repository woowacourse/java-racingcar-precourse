# 자동차 경주 게임
## 구현할 기능 목록
- [x] 1. 경주할 차량의 이름`name`을 사용자에게 입력 받기
  - [x] 1.1. 입력받은 문자열을 쉼표로 구분하여 각각 구분하기
  - [x] 1.2. 각 name의 길이가 5자 이하일 경우 재입력받기
- [x] 2. 사용자 입력 값을 통해 `name`을 가진 instance 생성
- [x] 3. 총 이동 횟수`totalMove` 입력받기
  - [x] 3.1. `totalMove` 입력이 숫자가 아닐 경우 재입력받기
  - [x] 3.2. `totalMove` 입력이 0이거나 음수일 경우 재입력받기
- [x] 4. 경주차 각각에 대한 `random` 값(0~9) 생성
- [x] 5. `random`값에 따른 `isFoward`의 여부(`random > 4`) 계산
- [x] 6. `isFoward`에 따른 `position` 변화 계산
- [x] 7. 4~6 실행에 따른 각 instance의 `position` 결과를 출력하기
- [x] 8. 4~7 실행을 `totalMove` 만큼 반복하기
- [ ] 9. 각 instance의 `position`을 비교하여 가장 큰 `position`을 가진 instance를 구해 `winner`로 선정
- [ ] 10. `winner`로 선정된 instance를 화면에 출력
## 기능 요구사항
1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
5. 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
## 프로그램 실행 결과
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과 
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux: --

pobi : ---
crong : --
pobi : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
honux : ----
crong : -----

pobi, honux가 최종 우승했습니다.
```
## 프로그래밍 요구 사항
### 객체
1. 다음 Car 객체를 활용해 구현해야 한다.
2. Car 기본 생성자를 추가할 수 없다.
3. name, position 변수의 접근 제어자인 private을 변경할 수 없다.
4. 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.
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
### 기존 요구사항
1. 3항 연산자를 쓰지 않는다.
2. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
3. 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.\
  3.1 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
### 추가 요구사항
1. 자바 코드 컨벤션을 지키면서 프로그래밍한다.\
  1.1. https://naver.github.io/hackday-conventions-java/ : 좀 더 개선된 컨벤션 참고 문서
2. 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
3. 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
4. else 예약어를 쓰지 않는다.\
  4-1. 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.\
  4-2. else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
