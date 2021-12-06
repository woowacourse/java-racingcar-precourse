#미션 - 🚗자동차 경주게임

##📈데이터 스트럭처 구조
 ```
racingcar
 ├─ Appliction.java
 ┃    └─ Car.java
 ┃	   └─ Randoms_method
 ┃    └─ Input.java
 ┃           └─ console_method
 └─ ApplictionTest
```

##✔️구현한 기능목록 

### 사용자 입력 
#### Input.java 
 - 자동차 이름을 한줄로 입력 받을 것 -> carNameArray[]
     - 쉼표로 자동차 이름을 구별한다.
     - 띄어쓰기 제거해준다.trim
  
 - 시도할 횟수 int로 입력 받기

### 자동차 객체 구현 
####Car.java
 - 0~9무작위값 하나 출력하는 함수
 - 4이상이면 position을 +1 증가시킨다
 - 현재 position을 visual로 보여주는 함수
 - 현재 position의 값을 출력
 - 인스턴스에서 차이름을 출력