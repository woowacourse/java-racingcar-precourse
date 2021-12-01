# 미션 - 자동차 경주 게임 🏎 
 : 자동차의 이름과 회수를 입력 받고 주어진 회수 동안 가장 많이 이동한 자동차가 우승하는 초간단 자동차 경주 게임   

## ✍🏻 구현할 기능 목록

-  ### [유저에게 자동차 이름 입력 받기]
    - camp.nextstep.edu.missionutils의 **Condsole** API의 **readLine()** 활용.
    - **"경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"** 출력.
    - 입력 받은 자동차들을 Car 객체로 ArrayList<Car> cars 에 담는다.     
    -  올바르지 않은 인풋 예외처리
       - IllegalArgumentException을 발생시킨 후 "[ERROR]" 로 시작하는 에러 메시지 출력.


-  ### [유저에게 시도할 회수 입력 받기]  
      - **"시도할 회수는 몇회인가요?"** 출력. 
      - camp.nextstep.edu.missionutils의 **Condsole** API의 **readLine()** 활용.
      - 올바르지 않은 인풋 예외처리
        - IllegalArgumentException을 발생시킨 후 "[ERROR]" 로 시작하는 에러 메시지 출력.
    
  
- ### [유저에게 실행 결과 알러주기]
    - ArrayList<Car> cars 에 들어있는 자동차들을 입력받은 시도 회수 만큼 반복문을 통해 전진할 지 멈출지 결정한 후 각 ArrayList<Result> results 에 결과 담기.
    - camp.nextstep.edu.missionutils의 **Randoms** API의 **pickNumberInRange()** 활용.
    - Random number 의 범위는 0에서 9사이.     
    - Random number 가 4이상일 경우 전진.
    - 자동차들의 전진과 멈춤의 상태를 cars 의 position 값으로 관리. 
    - **"실행 결과"** 출력.
    - results 의 결과들 알려주기 
  
  
- ### [유저에게 최종 우승자 알려주기]
  - **"최종 우승자 : ""** 출력
  - cars 의 자동차들 중 position 값이 가장 큰 자동차들 출력
    <br>
    

## 💻 프로그래밍 실행 결과 예시

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

## ✔️ Commit Conventions
- [feat]: 기능 추가 관련 커밋
- [fix]: 버그 수정 관련 커밋
- [docs]: 문서 관련 커밋
- [refactor]: 기능 수정 관련 커밋
- [test]: 테스트 관련 커밋

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.