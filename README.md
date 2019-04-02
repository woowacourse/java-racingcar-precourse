# 2주차 미션 - 자동차 경주 게임

## 기능 요구 사항
- 주어진 회수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하여 이름은 5자 이하만 가능하다.
- 사용자는 몇번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값이 4이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. 

## 프로그래밍 요구사항 - 객체

- 다음 Car 객체를 활용해 구현해야 한다.
- Car 기본 생성자를 추가할 수 없다.
- name, position 변수의 접근 제어자인 private을 변경할 수 없다.
- 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.

> public class Car{  
&nbsp;&nbsp;private final String name;  
&nbsp;&nbsp;int position = 0;  
&nbsp;&nbsp;public Car(String name){  
&nbsp;&nbsp;&nbsp;&nbsp;this.name = name;  
&nbsp;&nbsp;}  
}

## 프로그래밍 요구사항 - 1주차와 동일
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 참고문서: <https://google.github.io/styleguide/javaguide.html> 또는 <https://myeonguni.tistory.com/1596>
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다. 
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트 indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.

## 프로그래밍 요구사항 - 2주차 변경 및 추가
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 혀용하지 않늗다.

## 미션저장소 및 진행 요구사항
- 미션은 <https://github.com/woowacourse/java-racingcar> 저장소를 fork/clone해 시작한다.
- 기능을 구현하기 전에 java-racingcar/README.md파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
- 프로코스 과제 제출 문서 절차를 따라 미션을 제출한다.

## 구현해야될 객체
- Car  
  - setName(); // 차에 이름을 부여하는 기능 => 삭제
  - increasePosition(); // 차 포지션을 1칸 올리는 기능
  - makeRandomNums(); // 랜덤 숫자를 생성하는 기능
  - compareTo(); // 여러 차의 각각 포지션을 비교하는 기능
- Display  
  - getNames(); // 사용자로부터 자동차 이름을 받아오는 기능
  - getTrialNums(); // 사용자로부터 시도할 횟수를 받아오는 기능
  - showResults(); // 사용자에게 실행 결과를 보여주는 기능
  - showWinners(); // 사용자에게 우승 자동차를 보여주는 기능
- Game  
  - initGames(); // 게임을 시작하기 위해 사용자로부터 입력을 받고, 데이터를 초기화하는 기능
  - makeCars(); // 자동차 객체를 만드는 기능
  - decidesWinner(); // 우승 자동차를 결정하는 기능
  - goOneTurnForEachCar(); // 각각의 자동차를 한 턴 진행하는 기능
  - playGames(); // 게임을 진행하는 기능

## 프로그래밍 진행
1. 유저에게 경주할 자동차 이름을 묻는다.
2. 유저에게 시도할 횟수를 묻느다.
3. 입력받은 횟수 동안 반복문을 진행한다.
4. 자동차들은 랜덤 숫자를 뽑는다.
5. 랜덤 숫자에 따라 포지션을 재조정한다.
6. 턴이 종료됐다면 우승한 자동차의 이름을 보여준다.