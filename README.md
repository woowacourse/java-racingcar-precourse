# 구현할 기능 목록
* GenerateRandomNumber 


1주차에서 구현한 방식대로 0 - 9 number list를 만들고 shuffle하여 index 0번째만 사용했다.

* receiveCarName (Valid한 값인지 check 할 것)
 
자동차의 이름을 사용자로부터 받아서 Car 객체를 만들어 ArrayList에 추가 한다.

* printOneResult (하나의 Car 객체의 현재 position 출력)

현재 Car 객체의 현재 position 값 만큼 "-" 출력

* printWinner

최종 승자를 출력한다. "," 출력을 위해 리스트의 맨 마지막일 때를 제외하고 ", "를 출력한다.
리스트의 맨 마지막일 경우엔 나머지 문장을 출력하고 종료한다.
 
* getMaxPosition

printWinner를 위해 최종 우승자의 현재 position을 return 한다.
 
* receiveInput (사용자로부터 input을 받는다.)
 
사용자로부터 input을 받아서 List에 넣고 return 한다.

* checkInvalidName (2에서 valid 값 check하는 기능 분리)
 
받아온 자동차 이름이 6자보다 큰 경우엔 다시 사용자로부터 자동차 이름을 받는다.

#### 구현 중 고려해야 할 사항
1. Car Class의 name과 position이 private이기 때문에 클래스 내부에서 값을 수정해야 한다.
2. 하지만 name은 final로 선언되어 처음 선언한 값에서 바꿀수 없고, position은 setPosition을 쓰지 않아야 한다.
2. 기본 생성자를 수정하면 안된다.
3. if문이 있더라도, else문을 쓰지 않는다.


## 기능 요구 사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이
하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.


## 프로그래밍 요구 사항 - 객체
* 다음 Car 객체를 활용해 구현해야 한다.
* Car 기본 생성자를 추가할 수 없다.
* name, position 변수의 접근 제어자인 private을 변경할 수 없다.
* 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.

### 프로그래밍 요구 사항 - 1주차와 동일
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
* 참고문서: https://google.github.io/styleguide/javaguide.html 또는   https://myeonguni.tistory.com/1596
* indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
* 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
* 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.

### 프로그래밍 요구 사항 - 2주차 변경 및 추가
* 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다. •함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
* else 예약어를 쓰지 않는다.
* 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
* else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 미션 저장소 및 진행 요구 사항
* 미션은 https://github.com/woowacourse/java-racingcar 저장소를 fork/clone해 시작한다.
* 기능을 구현하기 전에 java-racingcar/README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
* 프리코스 과제 제출 문서 절차를 따라 미션을 제출한다.