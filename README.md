# 자동차 경주 게임

## 1. 구현 목록
- Car (class)
  - move : random 값이 4 이상일 경우 전진 (3 이하는 정지)
  - setRandomValue : random 값 생성
  - 
- RacingGame (class)
  - inputUserName : User name을 입력 받음
  - isValidUserName : 사용 가능한 user name 인지 검사
  - inputCount : 시도할 회수를 입력 받음
  - isValidCount : 사용 가능한 count인지 
  - printResult : 각 회수의 실행 결과 출력
  - printWinner : 우승자 출력
  

## 2. 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9사이에서 random값을 구한 후 random값이 4이상일 경우 전진하고, 3이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 3. 프로그래밍 요구사항
### 3.1. 객체
- 다음 Car객체를 활용해 구현해야 한다.
- Car 기본 생성자를 추가할 수 없다.
- name, position변수의 접근제어자인 private을 변경할 수 없다.
- 가능하면 setPosition(intposition)메소드를 추가하지 않고 구현한다.
### 3.2. 자바 코드 컨벤션
- 참고 : ttps://google.github.io/styleguide/javaguide.html, https://myeonguni.tistory.com/1596
- indent depth를 3이 넘지 않도록 구현한다. (2까지만 허용)
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게
### 3.3. 추가 사항
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
- 힌트 : if조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.


## 4. 참고
- 미션 저장소 : https://github.com/woowacourse/java-racingcar
- 과제제출 : https://github.com/woowacourse/woowacourse-docs/tree/master/precourse
