# java-racingcar
....와아아아아!!!! 함성소리가 들리는 경기장이 보이시나요? 여러분은 지금 박진감 넘치는 자동차 경주가
벌어지고 있는 자동차 경기장에 들어와 있습니다. 지금부터 곧 자동차 경주가 벌어집니다. 그런데 이게 웬일,
자동차가 출발하고 경기장에서 멀리 떨어진 트렉으로 가버리자 더이상 자동차가 보이지 않게 되어버렸습니다.
이제 여러분은 트렉에 있는 전광판을 통해 자동차의 위치와 순위가 어떻게 되는지 확인해야 합니다. 어디,
우리가 응원하는 자동차가 얼마나 앞서있는지 확인해볼까요?

# 프로젝트 목표
- 자바 코드 컨벤션 익히기
- 기능을 최대한 나누어 함수가 하나의 기능만 담당하도록, 그리고 기능이 중복되지 않도록 만들기
- 객체지향 프로그래밍 연습하기
- DDD(Domain Driven Design) 공부해보기

# 클래스별 기능 목록
## 1. Car Class
- 생성자를 통해 탑승자의 이름을 정해줄 수 있습니다.
- 자동차는 0~9 사이의 숫자를 랜덤하게 뽑을 수 있습니다.
- 자동차는 전진할 수 있습니다.
- 자동차는 랜덤 숫자를 뽑은 결과에 따라 전진할지 멈출지 결정합니다.
- 자동차에는 위치추적 센서가 달려있기 때문에, TrackingCenter에게 현재 위치를 알려줄 수
 있습니다.

## 2. TrackingCenter Class
TrackingCenter는 위치 자동차들의 위치 추적 기능 이외에도 위치와 관련된 여러가지 기능을
제공하는 통합 센터입니다. 그래서 경기장에는 심판이 필요 없습니다. 이제 자동화의 시대니까요!
- TrackingCenter는 각각의 자동차로부터 위치를 수신받습니다.
- 자동차들의 위치를 비교해서 순위를 매길 수 있습니다.
- 자동차들의 순위를 비교해 누가 우승인지 알려줄 수 있습니다.

## 3. DisplayBoard Class
현재 경기 상황을 보여주는 전광판입니다.
- 현재 자동차들의 위치정보를 TrackingCenter로부터 넘겨받아 각 자동차들의 실시간 위치를
보여줄 수 있습니다.
- TrackingCenter가 넘겨준 실시간 순위 3위까지 보여줄 수 있습니다. 실시간 순위를 지켜보며 관람하면
훨씬 박진감 넘치는 경기를 즐길 수 있겠지요?
- 누가 우승을 했는지 보여줄 수 있습니다.

## 4. RacingManager
레이싱 게임을 주관하는 매니저입니다.
- 참가자들의 이름을 입력받을 수 있습니다.
- 자동차들이 몇 번이나 이동할지 입력받을 수 있습니다.
- 자동차들에게 전진 신호를 보냅니다.

## 5. RacingGame Class
RacingGame class는 Car, RacingManager, DisplayBoard와 TrackingCenter로 이루어져 있습니다.
- RacingGame을 실행합니다.

## References
- DDD 관련 참고 링크 : https://opennote46.tistory.com/96?category=621589
- UML 클래스 다이어그램 작성법 : https://gmlwjd9405.github.io/2018/07/04/class-diagram.html
- 객체지향 모델링 : http://www.dbguide.net/db.db?boardUid=12843&boardConfigUid=9&boardIdx=31
- main() function 은 어디에 위치해야 하는가 : https://www.thoughtco.com/main-class-2034233
