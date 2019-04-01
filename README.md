# 2주차 미션 - 자동차 경주 게임

 - 랜덤으로 숫자가 나와 4이상일경우 전진하는 자동차 경주 게임

## 기능 요구 사항

 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
 * 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
 * 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이
하의 값이면 멈춘다.
 * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 프로그래밍 요구 사항

 * Car 객체를 활용해 구현해야 한다.
 * Car 기본 생성자를 추가할 수 없다.
 * name, position 변수의 접근 제어자인 private을 변경할 수 없다. 
 * 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.
 * 자바 코드 컨벤션을 준수하면서 프로그래밍을 한다.  
 	* (참고) <https://google.github.io/styleguide/javaguide.html>
 	* (참고) <https://myeonguni.tistory.com/1596>
 * indent(인덴트,들여쓰기) depth를. 2까지만 허용한다.
  	* [예] while문 안에 if문이 있으면 들여쓰기 값 : 2
 * 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다. 
 	* 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
 * else 예약어를 쓰지 않는다.
 	* 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
	* else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
	
## 미션 목표
```
 * 해당 미션에 대해 객체를 나눠본다.(Car객체, User객체, GameController객체 등)
 * 객체를 통해 클래스를 분리해 활용해 본다.
 * 정적인 타입으로 추상화 한 뒤 타입간의 관계를 설정후 객체지향을 설계하고 구현해본다.
``` 
 * (참고) <http://woowabros.github.io/study/2016/07/07/think_object_oriented.html>

	
## 구현 기능 목록

 1. Car 모델을 담을 Car 클래스 생성 -> name, position 설정
 2. 유저가 자동차 정보 입력할 Input클래스 생성 -> enrollCarName() 구현
 3. 게임의 내용을 console에서 출력할 Output클래스 생성 -> gameResult() 구현
 4. 전반적으로 게임을 진행하기 위한 GameController 클래스 생성 -> gameStart()구현
 5. 예외처리 할 Exception 클래스 생성
 6. 게임을 돌릴 Main 클래스 생성
