-기능 요구사항

 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 
 각 자동차에 이름을 부여
  
 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력
 
 자동차 이름은 쉼표, 를 기준으로 구분 , 이름은 5자 이하만 가능
 
 사용자는 몇 번의 이동을 할 것인지 입력
 
 전진 조건은 0~9 사이의 random 값 구하고 4 이상:전진, 3이하 멈춤
 
 완료 후 누가 우승했는지 알리기, 우승자는 한명 이상일 수도 있음
 
 -객체 요구사항

Car 객체 활용해 구현

Car 기본 생성자 추가하면 안됨

name, position 변수의 접근 제어자인 private 변경 불가

가능하면 setPosition(int position) 메소드를 추가하지 않고 구현

- 프로그래밍 요구사항

indent(들여쓰기) depth를 3이 넘지 않도록
while 문 안에 if 문이 있으면 들여쓰기는 2이다.
함수를 분리하면 들여쓰기 줄일 수 있다.

함수의 길이가 15라인 넘지 않도록 구현하기
함수가 한 가지 일만 하도록 구현

else 예약어 쓰지 말기
if 조건절에서 값을 return하는 방식으로 구현하면 else 사용안해도 됨
switch/case 도 쓰지 말자


-클래스 기능 구현

Car 클래스

'getPosition' - Position 반환

'getName' - Name 반환 

'MakeRandomNum'  - 0에서 9 사이의 값을 구한후 4 이상이면 위치 증가

'ResultPositon'  - 위치를 '-' 으로 표현

-RacingGame 클래스

'InputCarNames' - 자동차 이름을 입력 받음

'CheckCarNameLength' - 입력 받은 이름의 길이가 5 이상인지 체크

'SetCarList' - 입력받은 자동차를 등록

'HowManyGame' - 몇 번의 게임을 할지 입력

'GameStart' - 게임 시작 

'GetMaxPosition' - 자동차 Positon의 Max 값 반환

'WhoIsWin' - 최종 우승자 출력

