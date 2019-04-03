# 2주차 미션 - 자동차 경주 게임

## 기능 구현
* 주어진횟수동안n대의자동차는전진또는멈출수있다.
* 각자동차에이름을부여할수있다.전진하는자동차를출력할때자동차이름을같이출력한다.
* 자동차이름은쉼표(,)를기준으로구분하며이름은5자이하만가능하다.
* 사용자는몇번의이동을할것인지를입력할수있어야한다.
* 전진하는조건은0에서9사이에서random값을구한후random값이4이상일경우전진하고,3이
하의값이면멈춘다.
* 자동차경주게임을완료한후누가우승했는지를알려준다.우승자는한명이상일수있다.

## 프로그래밍 요구사항
* 자바코드컨벤션을지키면서프로그래밍한다.
  * 참고문서:https://google.github.io/styleguide/javaguide.html또는
https://myeonguni.tistory.com/1596
  * indent(인덴트,들여쓰기)depth를3이넘지않도록구현한다.2까지만허용한다.
  * 예를들어while문안에if문이있으면들여쓰기는2이다.
  * 힌트:indent(인덴트,들여쓰기)depth를줄이는좋은방법은함수(또는메소드)를분리하면된다.
* 함수(또는메소드)의길이가15라인을넘어가지않도록구현한다.
  * 함수(또는메소드)가한가지일만잘하도록구현한다.
* else예약어를쓰지않는다.
  * 힌트:if조건절에서값을return하는방식으로구현하면else를사용하지않아도된다.
  * else를쓰지말라고하니switch/case로구현하는경우가있는데switch/case도허용하지않는다.
  
## 프로그램 기능 목록

### class
* Car
* Game
* GameUI
* Main
* NameRuleException

#### Car
* tryMove()
  * 자동차 이동
* checkMove()
  * random 값을 구해서 이동 가능한지 확인
* getName()
  * 자동차 이름 반환
* getPosition()
  * 자동차 위치 반환

#### Game
* joinRace()
  * 자동차 경주 참여
* runLap()
  * 자동차 1랩 실행
* getCars()
  * 자동차 경주에 참여한 자동차의 상태
* getRaceChampion()
  * 자동차 경주 우승자 반환
  
#### GameUI
* run()
  * 게임 시작
* askCarNames()
  * 자동차들 이름 요청하기
* askLapNum()
  * 자동차 트랙 횟수
* startRace()
  * 자동차 트랙 횟수만큼 경기시작
* showLapResult()
  * 자동차 경주 결과 출력
* showRaceChampion()
  * 자동차 경주 우승자 결과 출력
  
#### Main
* main()
  * 프로그램 시작
  
#### NameRuleException
* 명명규칙 에러 클래스