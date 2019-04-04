# 2주차 미션 : 자동차 경주 게임

------

### 기능 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 정지한다.
- 각 자동차에 이름을 부여할 수 있다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하여 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 값을 입력한다.
- 전진하는 조건은 0에서 9사이의 random 값을 구한 후 4 이상일 경우 전진하고, 3 이하일 경우 정지한다.
- 게임을 완료한 후 우승자를 출력한다. (우승자는 한 명 이상일 수 있다.)

------

### 기능  목록

- 메인 기능

> 1. 자동차 이름 입력
> 2. 자동차 이름 파싱
> 3. 각각의 자동차 객체 생성
> 4. 시도 횟수 입력
> 5. 랜덤 값 생성
> 6. 생성 된 값에 따라 전진 or 정지
> 7. 전진 수행
> 8. 실행 결과 출력
> 9. 입력 횟수 수행 후 우승자 판단
> 10. 우승자 출력
> 11. 사용자 입력 검증

------

### Class  Method 설명

- RacingGame

> 1. void main(String[] args)				// 프로그램 실행, RacingGamePlay 객체 생성



- RacingGamePlay

> 1. RacingGamePlay()					// user 객체 생성
> 2. void play()							// 게임을 진행하는 함수
> 3. void excuteRacingBasedOnTrialCount()	// 입력 횟수에 따른 시행
> 4. void createCarObjects(String[] carNames)	// car 객체 생성
> 5. void actionAllCars()					// 모든 car 객체의 action을 결정하고 수행
> 6. void callAllCarsPrintFunction()			// 모든 car 객체에 대하여 print() 함수 호출
> 7. void printNowCarPosition(Car car)		// car 객체의 이름과 현재 position 을 출력



- User

> 1. User()							    // 사용자 입력을 받는 함수_input() 호출
> 2. void callInputFunction()					// 자동차 이름과 시행 횟수를 입력받는 함수 호출
> 3. void inputValidCarNames() 				// 자동차 이름 유효성 검사 후 세팅 
> 4. String[] inputStringCarNames()				// 자동차 이름 전체를 문자열로 받는 함수
> 5. String[] sliceInput(String carNames)			// 자동차 이름을 쉼표(,)로 구분
> 6. boolean checkValidNames(String[] slicedInput)		// 이름 유효성 검사 함수들 호출
> 7. boolean isOnlyComma(String[] slicedInput)			// 쉼표(, ) 만 입력하는 경우
> 8. boolean isBlankOrOverLength(String[] slicedInput)		// 공백, 글자 수 제한 검사
> 9. void inputValidNumberOfTrails()					// 시행 횟수 유효성 검사 후 세팅
> 10. void inputNumberOfTrials()						// 시행 횟수 입력
> 11. boolean checkValidNumber(String input)			// 숫자 유효성 검사 함수들 호출
> 12. boolean isNumber(String input)
> 13. boolean isBlankInput(String input)				// 입력을 안했을 경우
> 14. void setCarNames(String[] carNames)
> 15. void setNumberOfTrials(int numberOfTrials)
> 16. String[] getCarNames()
> 17. int getNumberOfTrials()



- Car

> 1. Car(String name)				// car 객체 생성
> 2. void moveCarPosition()			// position을 정해진 distance만큼 이동
> 3. String getName()	
> 4. int getPosition()



- Action

> 1. Action(Car car)
> 2. void actBasedOnDecision()			// 결정된 action 수행
> 3. boolean decideAction()				// 임의의 값이 4 이상일 경우 move
> 4. int makeRandomNumber()			// 0 ~ 9 사이의 임의의 값 생성



- Winner

> 1. Winner(Car[] cars)
> 2. void callFindWinnerFunctions()			// 우승자를 찾고, 출력
> 3. void findMaxDistance()				// car 객체들의 최대값 position을 찾아낸다.
> 4. void findWinner()					// position을 비교하여 우승자를 찾는다.
> 5. void addValidWinner(Car car)			// 우승자 판단, 우승자 리스트에 추가
> 6. boolean isMaxPosition(Car car)		// car 객체의 position 이 maxDistance 인지 판단
> 7. void printWinner()					// 우승자를 출력하는 함수
> 8. int max(int a, int b);
> 9. void setMaxDistance(int maxDistance)