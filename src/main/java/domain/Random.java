/*
 * @class       Random class
 * @version     1.0.0
 * @date        19.04.04
 * @author      OHSANG SEO (tjdhtkd@gmail.com)
 * @brief       just generate random number.
 */

package domain;

public class Random {
    private int randomNumber;

    public Random() {
        this.randomNumber = (int) (Math.random() * 10);
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
