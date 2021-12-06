# 미션 - 자동차 경주 게임


## 🚀 기능 요구사항

- [ ] 자동차의 이름 입력 기능 구현
  - [X] delimiter / 5자 이내 : 잘못된 입력 예외처리 하기
  - [ ] 입력받은 이름으로 각 자동차를 초기화
- [ ] 이동 시도 회수 입력 기능 구현
  - [X] 회수는 숫자 : 잘못된 입력 예외처리 하기
- [ ] 난수 추출
  - [X] 0~9 사이의 값이 아니면 예외처리 하기
  - [ ] 4 이상 : 전진 / 4 미만 : 정지
- [ ] 회수만큼 수행해 게임 완료시 우승자 출력
  - [ ] 한 명 초과 : 쉼표(,)로 구분하여 출력
  
**난수 생성**은 `Randoms`, **입력**은 `Console` API를 사용 

**잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 에러메시지 출력 후 다시 입력**

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


## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
