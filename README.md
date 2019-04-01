# Racing Car
## Class UserInterface
- 책임: 사용자에게 보여주는 역활들을 수행

#### inputCarName()
- 책임: 입력한 자동차 이름을 ','기준으로 분리
- 구현 방법: String으로 받고 split(',')함수를 사용해 이름들을 분리함
- return: String[] / 입력한 이름들

#### checkValidationCarName(String[] carNames)
- 책임: 입력받은 자동차 이름들이 유효한 조건에 적합한지 확인
- 구현 방법: 이름의 길이가 1~5사이인지 확인을 통해 유효성 검사함
- parameter: 입력한 자동차 이름들
- return: boolean / 유효(true), 무효(false)

#### inputCnt()
- 책임: 반복할 횟수 입력받아 반환해주는 것
- return: String / 반복할 횟수

#### checkValidationCnt(String cntStr)
- 책임: 입력받은 반복 횟수가 유효한지 검사
- 구현 방법
  1. cntStr의 입력 형태가 숫자인지 확인
  2. 숫자인 경우 MIN_NUMBER보다 큰지 확인
- parameter: 입력한 반복 횟수
- return: boolean / 유효(true), 무효(false)

#### printResultMenu()
- 책임: "실행결과"라는 문구 출력

#### printRacing(Car[] cars)
- 책임: 현재 자동차 객체들의 위치를 출력하는 것
- 구현 방법: 각 자동차 객체의 이름과 위치를 반환받고 이름을 출력후 위차만큼 반복해 '-'를 출력

#### printWInners(Car[] car)
- 책임: 자동차 객체들의 최종 결과를 통해 우승자를 알려주는 것
- 구현 방법
  1. 먼저 가장 멀리간 위치를 확인하기 위해 ArrayList와 Collections class를 사용
  2. 가장 멀리간 자동차의 이름은 printWinnerNames를 통해 받아 출력
  
 #### findMaxPosition(Car[] cars)
 - 책입: 경기가 끝난 자동차들의 위치 중 가장 멀리간 위치를 찾는 것
 - 구현 방법: ArrayList에 모든 자동차 위치를 넣고 Collections 클래스를 이용해 가장 멀리간 위치를 반환
 - parameter: 경주한 자동차 객체들
 - return: int / 가장 멀리간 위치

#### printWinnerNames(Car car, int maxPosition)
- 책임: 가장 멀리간 자동차 객체의 이름을 반환
- 구현 방법: 가장 먼 위치와 같은 자동차 객체의 이름을 반환 이때, 두번째부터는 이름뒤에 ', '가 붙어서 반환
- parameter: car-자동차 객체, maxPosition-가장 멀리간 위치

## Class Car
- 책임: 자동차 객체의 현 상항을 업데이트

#### Car(String name)
- 책임: 자동차 객체를 만드는 것
- parameter: 자동차 객체의 이름

#### updatePosition()
- 책임: 자동차 객체가 전진할지 안 할지 결정
- 구현 방법: generateRandom 메서드에서 반환된 값으로 조건에 맞는 확인후 맞으면 객체의 position을 증가

#### generateRandom()
- 책임: 전진 조건을 랜덤하게 반환
- 구현 방법: Random class의 nextInt()를 사용
- return: int / 랜덤한 숫자

#### getName()
- 책임: 자동차 객체의 이름을 알려줄
- return: String / 자동차 객체의 이름

#### getPosition()
- 책임: 현재 상항의 위치를 알려줄
- return: int / 현재 위치