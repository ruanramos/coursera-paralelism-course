package edu.coursera.parallel;

import junit.framework.TestCase;

public class ASumTest extends TestCase {

    ASum a = new ASum(0, 9, new int[]{ 1,2,3,4,5,6,7,8,9,10 });


    public void test() {
        assertEquals(a.Compute(), 55);
    }

}