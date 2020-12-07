# 미션 - 자동차 경주 게임
## 💻 기능 목록
- [x] "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력
- [x] 경주할 자동차의 이름들 입력
- [x] 쉼표로 이름 구분
    - [x] 예외 상황 시 "[ERROR] ~" 문구 출력
        - [x] 입력 값이 없을 경우
    	- [x] 자동차 이름이 5자 초과일 경우
    	- [x] 자동차 이름이 글자가 아닐 경우
    	- [x] 같은 자동차 이름이 존재할 경우
- [x] 입력한 이름별 ```Car``` 객체 생성
- [x] "시도할 횟수는 몇회인가요?" 출력
- [x] 시도할 횟수 입력
	- [x] 예외 상황 시 "[ERROR] ~"문구 출력
	    - [x] 입력 값이 없을 경우
    	- [x] 시도할 횟수가 정수가 아닌 경우
        - [x] 시도할 횟수가 1보다 작을 경우
- [x] "실행 결과" 출력
- [x] 각 차수별 자동차 ```position``` 결과 산출
    - [x] 각 자동차별 0에서 9 사이의 random 값 구하기
	    - [x] random 값이 4 이상일 경우 ```position``` 전진
        - [x] random 값이 4 미만일 경우 ```position``` 멈춤
    - [x] 각 자동차별 ```position``` 출력
- [x] position 값이 제일 높은 우승자 뽑기
- [x] 최종 우승자 출력

## 🏗 프로그램 구조
### 🗂 racingcar
**Application**
* 게임 실행

**Car**
* move : 자동차 객체의 위치 전진
* getName : 자동차 객체의 이름 반환
* getPosition : 자동차 객체의 위치 반환

**Game**
* run : 게임 실행
* inputProgress : 재시작, 종료 여부 입력
* setUp : 게임에 필요한 값들 세팅
* generateCar : 이름별 자동차 객체 생성
* showMovingResult : 각 차수별 실행 결과
* produceResult : 각 자동차별 결과 산출
* judgeMovement : 자동차가 판단
* generateRandomNumber : 0에서 9까지 랜덤 숫자 생성
* finish : 게임 종료
* produceMaxPosition : 가장 높은 위치값 산출
* selectWinner : 우승자 선정

**InputManager**
* inputCarNameArray : 사용자에게 경주할 자동차 이름들 입력받기
* inputTryNumber : 사용자에게 시도할 횟수 입력받기
* splitCarNamesWithComma : 쉼표(,) 기준으로 이름 분리
* stringToInteger : 문자열을 정수로 변환
* getCarNameArray : 자동차 이름 배열 반환
* getTryNumber : 시도할 횟수 반환

**OutputManager**
* printInputCarNamesMessage : "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력
* printInputTryNumberMessage : "시도할 횟수는 몇회인가요?" 출력
* printMovingResultHeader : "실행 결과" 출력
* printOutputEachResultPosition : 각 자동차별 ```position``` 출
* printOutputFinalWinner : 최종 우승자 출력
* printCarName : 자동차 이름 출력
* printCarPosition : 자동차 위치 출력

### 🗂 utils
**RandomUtils**
* nextInt : random 값 생성

**ValidationUtils**
* validateCarNameArray : 자동차 이름 배열 유효성 확인
* validateTryNumber : 입력한 시도할 횟수 유효성 확인
* isInvalidLength : 자동차 이름의 길이가 최대 길이를 넘지 않는지 확인
* isNotLetter : 자동차 이름이 문자인지 확인
* isNotDigit : 시도할 횟수가 숫자인지 확인
* hasDuplicateValue : 자동차 이름이 중복되었는지 