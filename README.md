1. 실제 racing game이 일어날 파일인 CarGameLauncher.java를 생성한다.
2. CarGameLauncher.java 안에 main method를 정의한다.
2-1 main method에서 작동할 doGame(), prepareGame(), playGame(), endGame()을 정의한다.
3. 자동차 이름을 묻는 getCarNames() method를 정의한다.
4. 경주를 몇번 할 것인지 묻는 askHowManyTurns() method를 정의한다.
5. User의 input이 맞는지 확인하는 ckechUserInput(), isNonNumberThere(), isItSmallerThanOne() method를 정의한다.
6. Class car를 instantiage하는 insatntiateAndReturn() method정의.
7. 자동차를 움직이는 updateCarMovements() method를 정의한다.
7-1. 자동차들이 움직인 거리를 계산하는 generateDistance() method를 정의한다.
8. 결과를 출력하는 printMovements() method를 정의한다.
10. 승자를 알리는 announceWinners() method를 정의한다.
10-1. 가장 높은 점수를 확인하는 decideMaxPosition() method를 정의한다.
10-2. 승자들을 추려내는 decideWinners() method를 정의한다.
10-3. 승자들을 출력하는 printWinners() method를 정의한다.