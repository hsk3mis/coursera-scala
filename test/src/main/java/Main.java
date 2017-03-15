/*
 * Copyright 2001,2017 (c) Point Of Sale Solutions (POSS) of Sabre Inc. All
 * rights reserved.
 * 
 * This software and documentation is the confidential and proprietary
 * information of Sabre Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Sabre Inc.
 */

import peanoNumbers.Natural;
import peanoNumbers.Succ;
import peanoNumbers.Zero$;
/**
 * Main
 *
 * @author Michal Gryglicki (SG0955419)
 * @since Mar 15, 2017
 */
public class Main
{
    public static void main(String[] args)
    {
        Natural one = new Succ(Zero$.MODULE$);
        Natural two = one.$plus(one);
        Natural three = two.successor();
        System.out.println(Zero$.MODULE$.getClass());
        System.out.println(three.getClass());
    }
}
