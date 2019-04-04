# 우아한테크코스 2주차 미션 : 자동차 경주 게임

## 실행 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,crong,honux

시도할 회수는 몇회인가요?
5

실행 결과 
pobi : - 
crong : - 
honux : -

pobi : -- 
crong : - 
honux : --

pobi : --- 
crong : -- 
honux : ---

pobi : ---- 
crong : --- 
honux : ----

pobi : ----- 
crong : ---- 
honux : -----

pobi, honux가 최종 우승했습니다
```


## 기능 요구사항

1. 자동차 이름들을 입력받는다.
2. 각각 자동차 object instance를 생성한다.
3. 시도 횟수를 입력받는다.
4. 자동차 별로 random number를 받는다.
5. 자동차를 전진/정지 한다.
6. 자동차 별 position을 출력한다.
7. 4-6를 시도 횟수만큼 반복한다.
8. postion으로 자동차들을 정렬한다.
0. max position인 자동차들을 출력한다.


## 프로그래밍 요구사항

* [Java Code Convention - En](https://google.github.io/styleguide/javaguide.html)
* [Java Code Convention - Ko](https://myeonguni.tistory.com/1596)
* indent dept < 3
* 1 method = 1 function
* method length < 15
* self-explanatory variable/method names


## 테스트 항목

1. input check 확인
2. random generator 확인
3. car position을 받고 최종 우승자를 결정하는 과정 확인