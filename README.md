# 미션 - 자동차 경주 게임

## 구현할 기능 목록 정리

### 게임 전 과정을 총괄할 게임 매니징 클래스
- Application 클래스에서는 게임 매니저를 생성해서 gameStart 메서드만 실행하게끔 구현
- gameStart 메서드를 읽어나가면 게임 과정을 그대로 파악할 수 있게끔 구현 

### 요구사항대로 입력을 처리하고, 에러를 핸들링하는 클래스
- 요청사항에 맞는 입력이 주어졌는지 검사하고, 에러 핸들링까지 구현
- 에러 메세지는 e.getMessage 로 할까 고민하다가, System.out.println 을 사용하기로 함

### 시스템 메세지는 하나의 클래스에 모아둔다.
- 출력 메세지를 하드코딩하지 않고, 메세지 전용 클래스에 상수(final static)로 선언해서 사용 

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
