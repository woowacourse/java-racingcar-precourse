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
 * 해당 미션에 대해 객체를 나눠본다.(Car객체, User객체, GameController객체 등)
 * 객체를 통해 클래스를 분리해 활용해 본다.
 * 정적인 타입으로 추상화 한 뒤 타입간의 관계를 설정후 객체지향을 설계하고 구현해본다.
 
 (참고) <http://woowabros.github.io/study/2016/07/07/think_object_oriented.html>

	
## 구현 기능 목록 및 함수 설명

###1. Car 모델을 담을 Car 클래스

 	* 자동차의 이름(name)과 위치(position)를 생성
 	* 자동차를 전진할지 말지 movePosition() 구현 -> 4이상이면 position 1증가
 	
###2. 유저가 자동차 정보 및 시도 횟수를 입력할 Input 클래스

  	* 사용자가 출전 시킬 자동차의 이름들을 입력할 enrollCarName() 구현
  	* 몇번 시도 할지 정하는 tryNumber() 구현
  	* 사용자의 입력들을 유효성 검사 시작(Exception 처리)
  	  	
###3. 게임의 진행 및 결과 내용을 console에서 출력할 Output 클래스

 	* gameOngoingMessage()을 통해 자동차의 이름과 현재 위치 출력
 	* 누가 이겼는지 console에 출력할 gameResultMessage() 구현 -> getWinner()를 통해 우승자 리스트를 생성
 	 
###4. 전반적으로 게임에 컨트롤을 위한 RaceingGameController 클래스

 	* 레이싱 게임을 시작하는 gameStart() 구현
 	* 자동차 객체들은(자동차 이름,위치) ArrayList<Car>로 등록
 	* 게임 결과를 알려주는 gameResult() 구현 -> raceingStart()를 통해 자동차 위치가 움직이기 시작
 	
###5. 사용자 입력에 예외처리 하는 InputException 클래스

 	* enrollCarOverlapName() : 자동차 이름이 중복되는게 있는지 확인
 	* enrollCarOverLength() : 자동차 이름이 5이하 인지 확인
 	* enrollCarBlankName() : 자동차 이름에 빈칸이 있는지 확인
 	* enrollCarOneName() : 자동차가 한대인지 확인
 	* enrollCarNullName() : 자동차가 이름이 없는지 확인
 	* enrollCarLastComma() : 마지막에 콤마를 붙였는지 확인
 	* tryNumberBlank() : 시도 횟수가 빈칸인지 확인
 	
###6. 예외 메세지 등록할 ErrorMessage 클래스

 	* 입력부분이 유효하지 않는다면 에러메세지 출력
 	
###7. 게임을 진행할 Main 클래스

 	* RaceingGameController 객체 생성하고 gameStart메소드 호출해 게임 시작

###8. Input,Output,InputException은 싱글톤으로 제작

