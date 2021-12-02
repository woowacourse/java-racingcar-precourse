# 자동차 경주 게임(2주차 미션) - 이주형

## 🚗 구현 기능 목록

### 사용자 입력
- 자동차 이름 입력
    - camp.nextstep.edu.missionutils.Console의 readLine()을 아용한다.
    - 자동차 이름을 쉼표(,)기준으로 구분하여 입력받는다.
        - [에외] 입력이 비어있는 경우
        - [예외] 입력이 쉼표로 끝나는 경우
        - [예외] 자동차 이름이 겹칠 경우
        - [예외] 자동차 이름 길이가 1이상 5이하가 아닌경우
        - [예외] 자동차 이름이 빈칸인 경우

- 시도 횟수 입력
    - 시도 횟수를 숫자로 입력한다.
        - [예외] 입력이 비어있는 경우
        - [예외] 숫자가 아닌 경우
        - [예외] 음수인 경우

### 전진 여부 결정
- 0에서 9 사이에서 무작위 값을 구한다
    - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()을 이용한다.
    - 무작위 값이 4 이상일 경우 "-"를 추가한다
    - 무작위 값이 4 이하일 경우 넘어간다.

### 진행 상황 출력
- 자동차 별로 여태까지의 진행상황을 출력한다.

### 종료
- 시도 횟수를 다 채우면 종료한다.

### 우승자 계산
- 완료한 뒤 전진수가 가장 많은 자동차(우승자)를 선별한다.

### 우승자 출력
- 1명 이상일 경우 쉼표(,)로 구분하여 출력한다.

# 📍 유의사항
- `IllegalArgumentException` + "[ERROR]"로 시작하는 에러 메시지를 출력후 그 시점부터 다시 입력받는다.
- Car 객체를 활용한다.
    - Car 기본 생성자를 추가할 수 없다
    - name, position 변수의 접근 제어자인 private을 변경할 수 없다.
    - 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다
- else 예약어를 쓰지 않는다.

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
