# 자동차 경주 게임
## 프리코스 2주차
### 구현순서
1. Car class 구현
    * 전진 기능
    
2. Main class 구현
    * 게임 실행
    * 게임 출력
------------------------------
#### Car class
#####Variables
1. ```
   String name
   ```
* 변수 이름 : name
* 타입 : String
* 
2. *int position*

#####Method
1.``` boolean movingForward()  ```
* 메소드 이름 : movingForward 
* 파라미터 : none
* 리턴 타입 : boolean
* 기능 : Random variable 를 생성하여 4이상인 경우 위치값을 1만큼 증가시키고,
 true 를 return 해준다. Random variable 값이 4미만인 경우엔 false 를 return 해준다.