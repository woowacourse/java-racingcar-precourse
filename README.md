# 미션 - 자동차 경주 게임

## 🚀 기능 목록

### 전진 조건

- ```camp.nextstep.edu.missionutils.Randoms```의 ```pickNumberInRange()``` 으로 0과 9사이에서 랜덤 값을 추출한다.
- 랜덤 값이 4 이상일 경우 전진한다.

### 자동차 이름

- 사용자는 여러 자동차 이름을 작성한다.
- 자동차 이름 사이에 쉼표(,)를 작성해 여러 자동차를 구분하며 작성한다.
- 자동차 이름은 5자 이하만 가능하다.
<br>

- 예외 처리
    - ```pobi,woni,nayoung,jun``` 으로 입력할 경우 ```nayoung``` 은 5글자를 초과하므로 잘못된 입력이다.
    - 입력 조건을 만족하지 못한 ```nayoung```을 기준으로 이전에 작성한 ```pobi```, ```woni```는 자동차 객체를 생성한다.
    - 사용자에게 다시 입력을 요구한다.