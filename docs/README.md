#미션 - 🚗자동차 경주게임

##📈데이터 스트럭처 구조
 ```
racingcar
 ├─ Appliction.java
 ┃    └─ Car.java
 ┃	   └─ Randoms_method
 ┃    └─ input.java
 ┃           └─ consoles_method
 └─ ApplictionTest
```

##✔️구현한 기능목록 

### 사용자 입력 
#### input.java 
 - 자동차 이름을 한줄로 입력 받을 것 -> carNameArray[]
     - 쉼표로 자동차 이름을 구별한다.
     - 띄어쓰기 제거해준다.trim
  
 - 시도할 횟수 int로 입력 받기
     - 잘못된 입력값이 에러를 발생시키고 다시 입력을 하겠끔하는 함수
