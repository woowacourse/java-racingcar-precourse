# 2주차 미션 - 자동차 경주 게임
***
	
##기능
1. ###UserInput 클래스 : __사용자의 입력__을 처리하는 클래스
	* setCarNames() : 올바른 입력을 받을 때까지 반복 후  __자동차 이름이 담긴 배열 반환__
	* setNumberOfAttep() : 올바른 입력을 받을 때까지 반복 후 __시도할 회수 반환__ 
	* inputCarNames() : __자동차 이름__을 입력 받는 함수.
	* splitCarNames() : __쉼표로 자동차를 구분__하여 저장하는 함수
	* inputNumberOfAttemp() : __시도할 회수 입력__ 받는 함수  
	
2. ###InputValidator 클래스 : 입력값을 __유효성 검사__하는 클래스
	* isValidCarNames(String[]) : 모든 자동차의 이름이 __5자 이하의 문자__인지 검사하는 함수
	* isValidNumberOfAttemp(String) : 시도할 회수가 __1이상의 정수__인지 검사하는 함수
	* checkCarNameLength(String) : 각 자동차의 이름이  __5자 이하의 문자__인지 검사하는 함수
	* isPositiveInteger(String) : 시도할 회수가 __1이상의 정수__인지 검사하는 함수
	* isBlank(String) : __빈값__을 입력했는지 검사하는 클래스  
	
3. ###Car 클래스 : __자동차 객체__를 구성하는 클래스
	* Car(String) : __자동차 생성자__
	* getName() : __자동차 이름__을 가져오는 함수
	* getPosition() : __자동차 위치__를 지정하는 함수
	* randomMovingDistance() : __난수__를 지정하는 함수
	* increasePosition() : 난수값이 4이상이면  __자동차가 1만큼 이동__하는 함수
	* printMovingDistance() : __자동차 위치__를 출력하는 함수  
	
4. ###RacingGame 클래스 : __자동차  경주 게임을 진행__클래스
	* RacingGame() : __자동차  경주 게임을 진행__하는 함수
	* setCarObject() : 이름을 가진 __자동차 객체를 생성__하는 함수
	* printCarNames() : 경주할 __자동차들의 이름을 출력__하는 함수
	* moveCar() : 자동차에 난수를 주어 __자동차를 이동__시키는 함수
	* getWinner() : 자동차 경주 게임의 __우승자를 가져오는__ 함수
	* printWinner() : 자동차 경주 게임의 __우승자를 출력__하는 함수 
	* main() : __게임 실행__하는 메인함수  
	