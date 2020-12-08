# 미션 - 자동차 경주 게임

## 🤞 구현할 기능 목록
### [게임 정보 받기]
- __경주할 여러개의 Car 이름 받기__
    - 쉼표로 Car 이름 구분하는 기능 구현
        - 유저 인풋이 ',' 로 끝나면 예외처리
        - Car 0개면 예외처리
        - 1자 ~ 5자 이내의 Car 이름 의외엔 예외처리
        - 중복되는 이름 예외처리
    - Car 이름 별로 Car 객체 생성
    - 생성된 Car 객체를 모두 담은 ArrayList<Car> 생성 

- __시도할 횟수 받기__
    - 정수가 아니면 예외처리
    - 0 이하 인풋은 예외처리

### [차수별 경주 진행하기]
- __각 차수 진행__
    - ArrayList<Car> 순차적으로 탐색
        - Car 객체에서 Random 번호 생성
        - 전진/멈춤 판별
        - Car 객체 position 변수 업데이트
        - 가장 앞서있는 Car 객체인지 확인

- __각 차수별 결과 출력__

### [우승자 안내]
- __가장 앞서있는 Car 객체 출력__

<br>

## 📜 디렉토리 구조 
- 제가 작업한 디렉토리는 다음과 같습니다
```bash 
|-- docs
|   `-- README.md
`-- src
    |-- main
    |   `-- java
    |       |-- racingcar
    |       |   |-- Application.java                - 어플리케이션을 실행
    |       |   |-- controller
    |       |   |   `-- SingleGame.java             - 순서에 알맞는 실행을 위해 domain-view를 연결
    |       |   |-- domain
    |       |   |   |-- Car.java                    - 자동차에 대한 정보를 저장 및 업데이트
    |       |   |   |-- TrialProgression.java       - 사용자가 입력한 차수 만큼 경주를 진행
    |       |   |   `-- Winners.java                - 최종 차수 후, 가장 앞서 있는 자동차를 판별
    |       |   `-- view
    |       |       |-- InputView.java              - 콘솔에서 사용자의 input을 받기
    |       |       `-- OutputView.java             - 콘솔에서 사용자에게 output을 보여주기
    |       `-- utils
    |           |-- RandomUtils.java                - Car의 전진/멈춤을 판별하는 난수 생성에 사용
    |           `-- exception
    |               |-- InputValidation.java        - 사용자가 알맞은 input을 입력했는지 검증
    |               `-- UserInputException.java     - 사용자가 틀린 input을 입력했을 때 발생시키는 예외
    `-- test
        `-- java
            `-- empty.txt

```    
    
<br>

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
