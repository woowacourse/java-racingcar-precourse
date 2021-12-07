# 미션 - 자동차 경주 게임

## 프로젝트 소개
본 프로젝트는 초간단 자동차 경주 게임을 구현한 프로젝트이다.
사용자가 입력한 횟수에 따라, n대의 자동차는 전진하거나 정지한다. 사용자가 입력한 횟수가 모두 실행되었을 때, 가장 멀리 전진한 자동차를 출력한다.

### 기능 소개
- 사용자는 자동차의 이름을 입력할 수 있다.
- 사용자는 게임을 진행할 횟수를 입력할 수 있다.
- 각 회에 현재까지의 모든 자동차의 이름과 거리를 알 수 있다.
- 마지막 회가 끝나면 최종 우승자를 출력할 수 있다.
- 사용자가 자동차의 이름과 진행 횟수를 입력할 때, 올바른 입력이 아닐 경우 다시 입력할 수 있다.

## 구현해야 할 기능
- car 객체 생성 (o)
### 시작
- 자동차의 이름을 입력받음 (o)
  - Console 사용 (o)
- 자동차의 이름을 split해서 각각 car 객체 생성 (o)
- 시도할 횟수 입력받기 (o)

<<게임 반복하기>>

### 게임의 진행(각 회 마다)
- 각 차 마다 무작위 난수 생성 (o)
- 무작위 난수에 따라 차가 갈지 안갈지 결정 (o)
  - 차가 간다면 현재 차의 위치 업데이트? (o)
- 각 회마다 실행 결과 보여주기 (o)

### 결과
- 최종 우승자를 계산 (o)
- 우승자 안내문구 출력 → 단독 / 공동 (o)

### 예외 상황
- 에러 문구 출력 (o)
- 자동차 이름 사이에 쉼표가 아니라 다른 기호가 들어감 -> 쉼표가 아니면 구분지어지지 않기 때문에 "이름이 5자 이상이다" 의 조건에 걸림 (o)
- 이름이 5자 이상임 (o)
- 사용자가 횟수 입력시에 숫자 말고 문자를 넣음 (o)
- 아무도 출발하지 않아서 간 거리가 0 인 경우 모두가 우승인가? -> 모두가 우승이라고 가정하고 진행(o)

## 확인해볼 사항
- [x]  함수의 길이가 15라인이 넘어가는 코드가 없어야한다.
- [x]  else 사용하지 않는다
- [x]  switch case도 안된다
- [x]  Car 객체를 만들어라

- [x]  커밋 메세지를 의미있게 작성하였는가(해당 커밋에서 작업한 내용에 대한 이해가 가도록 작성했는가)
- [x]  기능을 구현하면서 기능 목록을 업데이트 하였는가
- [x]  기능 목록을 재검토 하였는가
  - [x]  구현해야할 기능 목록을 정리하는데 집중했는가
  - [x]  예외적인 상황도 기능 목록에 정리하였는가
- [x]  Readme.md 에 해당 프로젝트가 어떤 프로젝트이며, 어떤 기능을 담고 있는지 기술하였는가

- [x]  이름을 통해 의도를 드러냈는가
- [x]  축약하지 않았는가
  - [x]  클래스와 메서드의 이름을 한 두 단어로 유지하려고 노력했는가
  - [x]  문맥을 중복하는 이름을 자제했는가
  - [x]  ex) 클래스 이름 Order. 함수 이름 ship(o) shipOrder(x) → order.ship()
- [x]  if,for,while 문 사이의 공백을 코딩 컨벤션에 맞췄는가
- [x]  공백 라인을 의미있게 사용하엿는가 → 문맥을 분리하는 부분에 사용했는가
- [x]  반복되는 코드(중복)가 없는가
- [x]  space와 tab을 혼용하지 않았는가
  - [x]  pr 을 보낸 후 들여쓰기가 잘 되어있는지 확인했는가
- [x]  의미 없는 주석을 달지 않았는가
- [x]  IDE의 코드 자동 정렬 기능을 활용했는가
- [x]  매직 넘버를 의미를 나타낼 수 있는 상수(static final)로 치환하여 코드 가독성을 높였는가
- [x]  구현 순서를 상수(or 클래스 변수) 인스턴스변수 생성자 메서드 순으로 작성했는가

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
