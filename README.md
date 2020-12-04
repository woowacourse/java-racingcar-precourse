# 미션 - 자동차 경주 게임

## 🤞 구현할 기능 목록
### 게임 정보 받기
- 경주할 여러개의 Car 이름 받기
    - 쉼표로 Car 이름 구분하는 기능 구현
        - 쉼표로 정확히 구분되지 않는 인풋은 예외처리
    - 구분된 Car 객체 생성
    - Car 객체를 담은 배열에 저장 
- 시도할 횟수 받기
    - 0 이하 인풋은 예외처리

### 차수별 경주 진행하기
- 각 Car 객체 별로 random 값 구해서 전진/멈춤 판별 
    - Car 객체의 position 변수 업데이트
- 각 Car 객체 별로 현재 위치 정보 "-" 를 통해 출력
- 가장 앞서있는 Car의 position 변수 저장

### 우승자 안내
- 가장 앞서있는 Car 객체 출력
    
## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
