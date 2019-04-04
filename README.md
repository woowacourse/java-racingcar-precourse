# 2주차 미션 - 자동차 경주 게임
***
	
##기능
1. ###UserInput 클래스 : 사용자의 입력을 처리하는 클래스
	* setCarNames() : 올바른 입력을 받을 때까지 반복 후  자동차 이름이 담긴 배열 반환
	* setNumberOfAttep() : 올바른 입력을 받을 때까지 반복 후 시도할 회수 반환 
	* inputCarNames() : 자동차 이름을 입력 받는 함수.
	* splitCarNames() : 쉼표로 자동차를 구분하여 저장하는 함수
	* inputNumberOfAttemp() : 시도할 회수 입력 받는 함수  
	
2. ###InputValidator 클래스 : 입력값을 유효성 검사하는 클래스
	* isValidCarNames(String[]) : 모든 자동차의 이름이 5자 이하의 문자인지 검사하는 함수
	* isValidNumberOfAttemp(String) : 시도할 회수가 1이상의 정수인지 검사하는 함수
	* checkCarNameLength(String) : 각 자동차의 이름이  5자 이하의 문자인지 검사하는 함수
	* isPositiveInteger(String) : 시도할 회수가 1이상의 정수인지 검사하는 함수
	* isBlank(String) : 빈값을 입력했는지 검사하는 클래스  
	
3. ###Car 클래스 : 자동차 객체를 구성하는 클래스
	* Car(String) : 자동차 생성자
	* getName() : 자동차 이름을 가져오는 함수
	* getPosition() : 자동차 위치를 지정하는 함수
	* randomMovingDistance() : 난수를 지정하는 함수
	* increasePosition() : 난수값이 4이상이면  자동차가 1만큼 이동하는 함수
	* printMovingDistance() : 자동차 위치를 출력하는 함수  
	
4. ###RacingGame 클래스 : 자동차  경주 게임을 진행클래스
	* RacingGame() : 자동차  경주 게임을 진행하는 함수
	* setCarObject() : 이름을 가진 자동차 객체를 생성하는 함수
	* printCarNames() : 경주할 자동차들의 이름을 출력하는 함수
	* moveCar() : 자동차에 난수를 주어 자동차를 이동시키는 함수
	* getWinner() : 자동차 경주 게임의 우승자를 가져오는 함수
	* printWinner() : 자동차 경주 게임의 우승자를 출력하는 함수 
	* main() : 게임 실행하는 메인함수  
	