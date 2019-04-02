package domain;

import java.util.Random;

public class Car {
        private final String name;
        private int position = 0;

        public Car(String name) {
                this.name = name;
        }

        public void movePosition() {
                if (drawRandomNumber()) {
                        position++;
                }

        }

        public boolean drawRandomNumber() { //뼈대 구축
                Random random = new Random();
                int n = random.nextInt(10);
                if (n >= 4) {
                        return true;
                }
                return false;
        }

        public int getPosition() {
                return this.position;
        }

        // 추가 기능 구현
}
