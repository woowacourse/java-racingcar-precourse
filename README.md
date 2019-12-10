# 레이싱 게임

### 설계 구조

**Main.java** 

static void main 함수 위치

**gameRunner/GameMachine.java**

게임을 실행 할 수 있는 함수가 담긴 클래스
여러개의 레이싱게임(RacingGame)을 실행 할 수 있다.

**gameRunner/RacingGame.java**

하나의 레이싱게임을 실행 할 수 있다.
하나의 레이싱 게임은 자동차의 이름을 입력받아 하나의 CarCollection을 생성하고 시도횟수를 갖고 있다. 

**domain/CarCollection.java**

하나의 자동차 집합(CarCollection)은 여러개의 Car를 갖고있다.

```json
[{"name":"pobi", "position": 1, "railID": 1}, 
{"name":"crong", "position": 1, "railID": 2},
{"name":"honux", "position": 1, "railID": 3}]
```

**domain/Car.java**

하나의 차는 name, position, railId를 갖고있다.
이때 railId를 설정한 이유는, 이후 요구사항이 확장되었을 때, 하나의 CarCollection중 하나의 Rail이 사라질 때, name의 unique함 보다는 railId의 유니크함을 이용해서 판단하면 좋을 것 같다고 판단했기 때문이다.

Car의 railId를 부여하기위해 CarCollection에  Id를 부여하는데 도움을 주는 멤버변수인 injectionId를 이용해 부여한다.

**view/InputView.java**

게임시 유저에게 입력을 받을때의 함수들을 저장한다.

**view/OutputView.java**

게임시 인자로 받은 값의 출력을 해야할 때의 함수들을 저장한다.

**util/StringParsing.java**

입력받은 String을 , 로 구분하여 List<String> 으로 만든다. 이때, trim() 연산까지 다 해준다.

**util/RandomNumberGenerator.java**

Boundary를 지정하여 정수타입의 숫자를 랜덤으로 생성할 수 있다.

**util/CustomErrorMessage.java**

ErrorMessae를 한 곳에서 관리하기 위한 클래스이다.





### 구현 기능 목록

- [x] feat 1 : 전진 조건을 결정할 수 있도록 random하게 숫자를 생성한다.
- [x] feat 2 : 입력받은 자동차 이름이 5자 이하인지 체크한다. -> Error 1 에도 적용
- [x] feat 3 : 입력받은 횟수만큼 전진을 시도한다
- [x] feat 4 : 사용자의 입력을 받는다.
- [x] feat 5 : 자동차의 위치를 화면에 출력한다.
- [x] feat 6 : 전진 조건에 따라 자동차의 위치를 전진 or 멈춤하도록 수정한다.
- [x] feat 7 : 입력받은 String을 List로 변경한다.
- [x] feat 8 : 각 Car는 고유한 번호를 갖는다. 이 고유한 번호는 racingGame의 몇번 rail에 위치하는지를 의미한다.
- [x] feat 9 : 설계를 위한 기본 구조 잡기
- [x] Error 1 : 입력받은 자동차 이름이 5가 아닐경우 IllegalArgumentException 호출
- [x] Error 2 : 입력받은 자동차 이름이 입력이 안 되있을 경우 IllegalArgumentException 호출
- [x] Error 3 : List의 MAX값 계산 중 이것을 찾아올 수 없으면, IllegalArgumentException 호출



### 나의 커밋메세지 규칙

[ feat **1** ] : 000 기능구현

[ doc ]  :  readme에 feat **N** 추가

[ refactor **1** ] : 000 기능 수정 및 추가



### 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고,  3이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.



### 프로그램 실행 결과

```
경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)
pobi, crong, honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi:-
crong:-
honux:-

pobi:--
crong:-
honux:--

pobi:---
crong:--
honux:---

pobi:----
crong:---
honux:----

pobi:-----
crong:----
honux:-----

pobi, honux가 최종 우승했습니다.
```



### 프로그래밍 요구사항

- 3항 연사자를 쓰지 않는다
- indet(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- 함수의 길이가 15라인을 넘어가지 않도록 구현한다 **[체크하기]**
- else를 쓰지 않는다.



### 추가로 기억할 사항

- 이름을 통해 의도를 드러내라
- 축약하지 마라
- code format 기능을 활용하라
- space도 convention이다.
- 불필요하게 공백 라인을 만들지 않는다. **[체크하기]**
- 구현 순서도 convention이다. **[체크하기]**
- 반복하지 마라 
- space vs tab 활용
- 의미없는 주석을 달지 않는다.
- 값을 하드코딩 하지 마라 (static final을 사용)
- git commit 메시지를 의미있게 작성하라 **[체크하기]**
- 기능목록 업데이트 readme.md는 기능 구현을 하면서 변경할 수 있다. **[체크하기]**
- 기능 구현 목록 : class 설계 구현과 같이 너무 자세하게 하지 않는다 > 정상적인 경우 + 예외적인 상황도 기능목록에 정리한다. **[체크하기]**
- README.md를 상세히 작성한다