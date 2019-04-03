package domain;

public class Car {
        private final String name;
        private int position = 0;

        public Car(String name) {
                this.name = name;
        }

        public void printPosition() {
                for (int i = 0; i < this.position; i++) {
                        System.out.print("-");
                }
                System.out.println();
        }

        public void printName() {
                System.out.print(this.name);
        }

        public void moveCar() {
                this.position++;
        }

        public int getPosiotion() {
                return this.position;
        }
}
