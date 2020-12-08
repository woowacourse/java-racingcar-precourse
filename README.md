# 미션 - 자동차 경주 게임

## 🌞기능 목록🌝

### 🚗Cars 클래스
|기능|메소드명|
|-------|-----|
|자동차의 이름을 반환|getName()|
|자동차의 현재 위치를 반환|getPosition()|
|난수를 발생시켜 전진 유무를 결정|determineMove()|
|자동차의 위치를 한 칸 전진|movePosition()|

### ⌨InputUtils 클래스
|기능|메소드명|-|
|-------|-----|---|
|(,)로 구분된 자동차들의 이름을 입력받음|inputCarsName()|5자리 초과, 빈 입력 예외처리|
|진행할 경기 숫자를 입력받음|inputNumberOfGame()|숫자 제외한 입력 예외처리|

### 💻PrintUtils 클래스
|기능|메소드명|-|
|-------|-----|---|
|이름을 입력하라는 안내를 출력|printInputNamesGuide()|
|경기 횟수를 입력하라는 안내를 출력|printInputNumberGuide()|
|예외 처리에 대한 안내를 출력|printErrorMessage()|
|차량들의 전진 상황을 출력|printCarsPosition()|
|우승한 차(들)의 목록을 출력|printWinners()|

### ⚖ValidationUtils 클래스
|기능|메소드명|-|
|-------|-----|---|
|자동차 이름이 유효한 값인지 확인|isValidName()|
|경기 회수가 유효한 값인지 확인|isValidNumberOfGame()|

### 🚥Racing 클래스
|기능|메소드명|-|
|-------|-----|---|
|이름 리스트를 받아서 Car 객체를 생성|setCarList()|
|게임 회수를 입력받아 설정|setGameNumber()|
|게임 횟수만큼 레이싱 게임을 진행|carRacing()|
|각 게임마다 자동차의 전진 상황을 출력|printCarPositions()|
|어떤 차(들)가 우승했는지 계산|whichCarsWin()|

## ❌예외 처리

### 🚗🙅‍자동차 이름 입력
- printNameErrorMessage() 발생
- 출력 메시지: [ERROR] 이름은 5자리 이하 문자를 입력해주세요.
````
a,b,c,,d
,a,b,c,d        //빈 이름 입력
a,b,cccccc,d    //5자를 초과하는 입력 
````

### 🔢🙅‍시도 회수 입력
- printNumberErrorMessage() 발생
- 출력 메시지: [ERROR] 양의 정수를 입력해주세요.
````
k   //숫자가 아닌 입력
-4 
0
1.4 //양의 정수가 아닌 입력
````

<br>

### 💻 프로그래밍 실행 결과 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자: pobi, jun
```

<br>


## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
