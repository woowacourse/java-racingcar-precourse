# 👉기능구현목록 👈

### 0. Car 자료구조생성
- String name
- int position
- Car(String name) : 생성자
- getPosition()
- getName()
- go() : 전진 처리하는 함수

### 1. Racable 인터페이스 생성

### 2. Racing 클래스 생성

- Car[] cars : Car 인스턴스 배열
- int trial : 시도 횟수  
---
- printNameAskMsg() : 경주할 자동차의 이름을 입력하라는 문구를 띄움
- areValidNames(String names) : 입력받은 이름이 유효한지 검사하는 함수
- getNames() : 자동차의 이름을 입력받는 함수
- createCars(String[] names) : 입력받은 유효한 이름으로 Car 인스턴스들을 생성하는 함수  
---
- printTrialAskMsg() : 시도할 횟수를 입력하라는 문구를 띄움
- isValidTrial(String trial) : 입력된 시도횟수가 유효한지 검사하는 함수
- getTrial() : 이동횟수를 입력받는 함수  
---
- doesGoOrStop() : 랜덤수 발생시켜 전진 혹은 정지를 결정하는 함수
- printCarPosition(int num) : 자동차의 이름별 이동거리를 띄울 함수 
- printProcess() : 전체 자동차의 이름별 이동거리를 띄울 함수
- printWinner() : 우승자를 띄울 함수
- run() : 경주가 실행되는 함수
