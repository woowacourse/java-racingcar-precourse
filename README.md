# 자동차경주게임

자동차 경주 게임은 Car class를 기반으로 진행되는 미니 게임입니다.  
게임의 진행 과정은 다음과 같습니다.  
1. 자동차 이름을 입력받습니다.  
2. 이동 횟수를 입력받습니다.  
3. 각 자동차 별로 Random Num을 받아서 전진 조건에 부합하면 전진, 아니라면 멈춥니다.  
4. 전진한다면 "자동차 이름 : - " 이런 식으로 전진 여부를 표시해 줍니다. 멈췄다면 표시하지 않습니다.  
5. 이동 횟수가 끝나고 나서, 자동차 별로 가지고 있는 position을 비교하여 우승자를 결정합니다.

## TODO-List

- [x] create start()
- [x] create class Input 
- [x] create Input.readName()
- [x] create Input.countNumberOfCars()
- [x] create Input.countMovings()
- [x] create Input.giveCarName()
- [x] specify class Car
- [x] create getter
- [x] create Car.goOrStop() - use Math.random()
- [x] create printResult()
- [x] create FarthestLocation()
- [x] create printWinner()
- [ ] create noticeWinner()
- [ ] create compareWhoIsWinner()