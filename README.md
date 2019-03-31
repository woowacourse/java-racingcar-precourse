# 프리코스 2주차 미션 : 자동차 경주 게임
---
# 기능 요구 사항
+ 주어진 횟수 동안 **n**대의 자동자는 전진 또는 멈출 수 있다.
+ 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
+ 자동차 이름은 쉼표를 기준으로 구분하며 이름은 **5자 이하** 만 가능하다
+ 사용자는 몇 번의 이동을 할 것인지 입력할 수 있어야 한다.
+ 전진하는 조건은 0~9사이의 random 값을 구한 후 random	값이 4이상일 경우 전진하고, 3이하의 값이면 멈춘다.
+ 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
---
#프로그래밍 요구사항
+ Car 객체를 활용해 구현해야 한다.
+ Car 기본 생성자를 추가할 수 없다.
+ name, position 변수의 접근 제어자인 private를 변경핳 수 없다.
+ 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.
+ 자바 코드 컨벤션을 지키면서 프로그래밍한다.
+ indent(들여쓰기) depth를 3이 넘지 않도록 구현한다.
+ 함수(또는 메소드)의 길기가 15라인을 넘어가지 않도록 구현한다.
+ else 예약어를 쓰지 않는다.
---
# 구현 기능 목록
+ Car객체에서 변수 값을 받아오는 기능(getPosition, getName) 

+ 입력을 받는 기능(static : carArr, numMove, numCar)
 + 입력된 이름들을 ','로 split하여 ArrayList에 저장하는 기능
 + 주어진 String이 이름에 적합한지(length<5) 판변하는 기능

+ 이번 라운드에서 갈지 말지 boolean 값 리턴하는 기능(final instance : threshold = 4;)
+ 이동을 한번 하는 기능 (position, static maxPosition 업데이트 ) 
+ 이동을 주어진 횟수만큼 반복하며 1등 차와 이동거리를 기록하는 기능 

+ 현재 상태 출력 기능(print())
 + toString override (name:\t-*position) 

+ 최종 결과 출력 기능
---
# 실행결과 예
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행결과
pobi:	-
crong:	-
honux:	-


pobi:	--
crong:	-
honux:	--


pobi:	---
crong:	--
honux:	---


pobi:	----
crong:	---
honux:	----


pobi:	-----
crong:	----
honux:	-----

pobi, honux가 최종 우승 했습니다.
