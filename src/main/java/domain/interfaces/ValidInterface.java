/*
 * ValidInterface interface
 *
 * @version 2
 *
 * @date 2019-04-02
 *
 * Copyright (c) 2019. Jihun oh
 * All rights reserved
 */

package domain.interfaces;

public interface ValidInterface {

    boolean validCarNameLength(String[] carNames);

    boolean validCarNameDuplicate(String[] carNames);

    boolean validCarCount(String[] carNames);

    boolean validGameCount(String times);
}
